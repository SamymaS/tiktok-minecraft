package com.tiktoklive.events;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EventHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Gson gson = new Gson();

    public void handleEvent(String jsonMessage) {
        try {
            JsonObject event = gson.fromJson(jsonMessage, JsonObject.class);
            String type = event.get("type").getAsString();

            LOGGER.info("Traitement de l'événement: {}", type);

            switch (type) {
                case "gift":
                    handleGift(event);
                    break;
                case "donation":
                    handleDonation(event);
                    break;
                case "like":
                    handleLike(event);
                    break;
                case "comment":
                    handleComment(event);
                    break;
                case "follow":
                    handleFollow(event);
                    break;
                case "test":
                    handleTest(event);
                    break;
                default:
                    LOGGER.warn("Type d'événement inconnu: {}", type);
            }
        } catch (Exception e) {
            LOGGER.error("Erreur lors du traitement de l'événement: ", e);
        }
    }

    private void handleGift(JsonObject event) {
        String giftName = event.has("giftName") ? event.get("giftName").getAsString() : "Cadeau";
        int giftValue = event.has("giftValue") ? event.get("giftValue").getAsInt() : 0;
        String sender = event.has("sender") ? event.get("sender").getAsString() : "Anonyme";

        broadcastMessage("🎁 " + sender + " a envoyé: " + giftName + " (valeur: " + giftValue + ")");

        // Spawn d'items basé sur la valeur du cadeau
        if (giftValue > 0) {
            spawnItems(giftValue / 10); // 1 item pour 10 de valeur
        }

        // Effet de vitesse pour les gros cadeaux
        if (giftValue > 100) {
            applyEffectToPlayer(MobEffects.MOVEMENT_SPEED, 200, 1);
        }
    }

    private void handleDonation(JsonObject event) {
        double amount = event.has("amount") ? event.get("amount").getAsDouble() : 0;
        String currency = event.has("currency") ? event.get("currency").getAsString() : "USD";
        String sender = event.has("sender") ? event.get("sender").getAsString() : "Anonyme";
        String message = event.has("message") ? event.get("message").getAsString() : "";

        broadcastMessage("💰 " + sender + " a fait un don de " + amount + " " + currency);

        // Spawn d'items précieux pour les donations
        int diamondCount = (int) (amount / 5); // 1 diamant pour 5 unités
        if (diamondCount > 0) {
            spawnDiamonds(diamondCount);
        }

        // Effet de régénération pour les donations importantes
        if (amount > 50) {
            applyEffectToPlayer(MobEffects.REGENERATION, 400, 1);
        }
    }

    private void handleLike(JsonObject event) {
        int count = event.has("count") ? event.get("count").getAsInt() : 1;
        String sender = event.has("sender") ? event.get("sender").getAsString() : "Anonyme";

        if (count > 10) {
            broadcastMessage("❤️ " + sender + " a envoyé " + count + " likes!");
            // Effet visuel pour beaucoup de likes
            applyEffectToPlayer(MobEffects.GLOWING, 100, 0);
        }
    }

    private void handleComment(JsonObject event) {
        String text = event.has("text") ? event.get("text").getAsString() : "";
        String sender = event.has("sender") ? event.get("sender").getAsString() : "Anonyme";

        // Actions basées sur des mots-clés dans les commentaires
        String lowerText = text.toLowerCase();
        if (lowerText.contains("spawn") || lowerText.contains("apparition")) {
            spawnItems(5);
            broadcastMessage("✨ " + sender + " a demandé un spawn!");
        } else if (lowerText.contains("speed") || lowerText.contains("vitesse")) {
            applyEffectToPlayer(MobEffects.MOVEMENT_SPEED, 300, 1);
            broadcastMessage("⚡ " + sender + " a demandé de la vitesse!");
        }
    }

    private void handleFollow(JsonObject event) {
        String sender = event.has("sender") ? event.get("sender").getAsString() : "Anonyme";
        broadcastMessage("👋 " + sender + " a suivi la chaîne!");
        spawnItems(3);
    }

    private void handleTest(JsonObject event) {
        broadcastMessage("🧪 Événement de test reçu!");
        spawnItems(1);
    }

    private void broadcastMessage(String message) {
        var server = ServerLifecycleHooks.getCurrentServer();
        if (server != null) {
            server.getPlayerList().broadcastSystemMessage(
                Component.literal(message),
                false
            );
        } else {
            // Mode client
            if (Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.displayClientMessage(
                    Component.literal(message),
                    false
                );
            }
        }
    }

    private void spawnItems(int count) {
        try {
            var server = ServerLifecycleHooks.getCurrentServer();
            if (server != null) {
                ServerLevel level = server.overworld();
                for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                    BlockPos pos = player.blockPosition();
                    for (int i = 0; i < count; i++) {
                        ItemEntity item = new ItemEntity(
                            level,
                            pos.getX() + (Math.random() - 0.5) * 3,
                            pos.getY() + 1,
                            pos.getZ() + (Math.random() - 0.5) * 3,
                            new ItemStack(Items.GOLD_INGOT)
                        );
                        level.addFreshEntity(item);
                    }
                }
            } else {
                // Mode client - on ne peut pas spawner d'entités, mais on peut donner les items directement
                if (Minecraft.getInstance().player != null) {
                    for (int i = 0; i < count; i++) {
                        Minecraft.getInstance().player.getInventory().add(new ItemStack(Items.GOLD_INGOT));
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("Erreur lors du spawn d'items: ", e);
        }
    }

    private void spawnDiamonds(int count) {
        try {
            var server = ServerLifecycleHooks.getCurrentServer();
            if (server != null) {
                ServerLevel level = server.overworld();
                for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                    BlockPos pos = player.blockPosition();
                    for (int i = 0; i < count; i++) {
                        ItemEntity item = new ItemEntity(
                            level,
                            pos.getX() + (Math.random() - 0.5) * 3,
                            pos.getY() + 1,
                            pos.getZ() + (Math.random() - 0.5) * 3,
                            new ItemStack(Items.DIAMOND)
                        );
                        level.addFreshEntity(item);
                    }
                }
            } else {
                // Mode client - donner les items directement
                if (Minecraft.getInstance().player != null) {
                    for (int i = 0; i < count; i++) {
                        Minecraft.getInstance().player.getInventory().add(new ItemStack(Items.DIAMOND));
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("Erreur lors du spawn de diamants: ", e);
        }
    }

    private void applyEffectToPlayer(net.minecraft.world.effect.MobEffect effect, int duration, int amplifier) {
        try {
            var server = ServerLifecycleHooks.getCurrentServer();
            if (server != null) {
                for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                    player.addEffect(new MobEffectInstance(effect, duration, amplifier));
                }
            } else {
                // Mode client
                if (Minecraft.getInstance().player != null) {
                    Minecraft.getInstance().player.addEffect(new MobEffectInstance(effect, duration, amplifier));
                }
            }
        } catch (Exception e) {
            LOGGER.error("Erreur lors de l'application d'effet: ", e);
        }
    }
}

