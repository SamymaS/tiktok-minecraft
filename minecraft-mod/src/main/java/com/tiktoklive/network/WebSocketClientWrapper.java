package com.tiktoklive.network;

import com.tiktoklive.events.EventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WebSocketClientWrapper {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String serverUrl;
    private final EventHandler eventHandler;
    private WebSocketClient webSocketClient;
    private boolean shouldReconnect = true;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public WebSocketClientWrapper(String serverUrl, EventHandler eventHandler) {
        this.serverUrl = serverUrl;
        this.eventHandler = eventHandler;
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void connect() {
        try {
            LOGGER.info("Tentative de connexion au serveur: {}", serverUrl);
            
            URI serverUri = URI.create(serverUrl);
            webSocketClient = new WebSocketClient(serverUri) {
                @Override
                public void onOpen(ServerHandshake handshake) {
                    LOGGER.info("✅ Connecté au serveur TikTok Live");
                    
                    // Afficher un message dans le chat sur le thread principal
                    Minecraft.getInstance().execute(() -> {
                        if (Minecraft.getInstance().player != null) {
                            Minecraft.getInstance().player.displayClientMessage(
                                Component.literal("✅ Connecté au serveur TikTok Live"),
                                false
                            );
                        }
                    });
                }

                @Override
                public void onMessage(String message) {
                    LOGGER.info("Message reçu: {}", message);
                    
                    // Traiter le message sur le thread principal de Minecraft
                    Minecraft.getInstance().execute(() -> {
                        eventHandler.handleEvent(message);
                    });
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    LOGGER.warn("Connexion fermée: {} - {} (remote: {})", code, reason, remote);
                    
                    // Tentative de reconnexion après 5 secondes
                    if (shouldReconnect) {
                        scheduler.schedule(() -> {
                            LOGGER.info("Tentative de reconnexion...");
                            connect();
                        }, 5, TimeUnit.SECONDS);
                    }
                }

                @Override
                public void onError(Exception ex) {
                    LOGGER.error("Erreur WebSocket: ", ex);
                }
            };
            
            webSocketClient.connect();
                
        } catch (Exception e) {
            LOGGER.error("Erreur lors de la connexion: ", e);
            
            // Tentative de reconnexion après 5 secondes en cas d'erreur
            if (shouldReconnect) {
                scheduler.schedule(() -> connect(), 5, TimeUnit.SECONDS);
            }
        }
    }

    public void disconnect() {
        shouldReconnect = false;
        if (webSocketClient != null) {
            webSocketClient.close();
        }
        scheduler.shutdown();
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        // Vérifier périodiquement la connexion
        if (event.phase == TickEvent.Phase.END && 
            webSocketClient != null && 
            webSocketClient.isClosed() && 
            shouldReconnect) {
            connect();
        }
    }
}


