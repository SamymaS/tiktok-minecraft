package com.tiktoklive;

import com.tiktoklive.network.WebSocketClientWrapper;
import com.tiktoklive.events.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TikTokLiveMod.MODID)
public class TikTokLiveMod {
    public static final String MODID = "tiktoklive";
    private static final Logger LOGGER = LogManager.getLogger();
    
    private WebSocketClientWrapper webSocketClient;
    private EventHandler eventHandler;

    public TikTokLiveMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Initialisation du mod TikTok Live");
        
        // Initialisation du gestionnaire d'événements
        eventHandler = new EventHandler();
        
        // Connexion au serveur WebSocket
        String serverUrl = System.getProperty("tiktok.server.url", "ws://localhost:3001");
        webSocketClient = new WebSocketClientWrapper(serverUrl, eventHandler);
        
        event.enqueueWork(() -> {
            webSocketClient.connect();
        });
    }
}

