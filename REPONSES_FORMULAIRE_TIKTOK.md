# 📝 Réponses pour le formulaire TikTok App Details

## ✅ Réponses exactes à copier-coller

### 1. Terms of Service URL *
```
https://samymas.github.io/tiktok-minecraft/terms.html
```

### 2. Privacy Policy URL *
```
https://samymas.github.io/tiktok-minecraft/privacy.html
```

### 3. Web/Desktop URL *
```
https://samymas.github.io/tiktok-minecraft/
```

### 4. Explain how each product and scope works within your app or website *
```
PRODUIT : TikTok Live API

SCOPE : live.streaming
- Utilisation : Recevoir les événements en temps réel pendant un live TikTok (cadeaux, donations, likes, commentaires, abonnements)
- Fonction : L'application écoute les webhooks TikTok pour capturer les interactions des spectateurs et les transmettre à Minecraft via WebSocket
- Flux : TikTok Live → Webhook HTTP → Serveur Node.js → WebSocket → Mod Minecraft → Actions dans le jeu

SCOPE : user.info.basic
- Utilisation : Obtenir les informations de base du compte TikTok (nom d'utilisateur, ID unique)
- Fonction : Identifier l'utilisateur qui envoie les interactions pour les afficher dans le jeu Minecraft (messages dans le chat, notifications)

FLUX COMPLET DE L'INTÉGRATION :
1. L'utilisateur démarre un live sur TikTok
2. Les spectateurs envoient des cadeaux, donations, likes ou commentent pendant le live
3. TikTok envoie ces événements à notre serveur backend via webhook HTTP (endpoint : /webhook/tiktok)
4. Notre serveur Node.js traite les événements et les transmet à Minecraft via WebSocket en temps réel
5. Le mod Minecraft (Forge) reçoit les événements via WebSocket et déclenche des actions dans le jeu :
   - Spawn d'items (or, diamants) selon la valeur des cadeaux/donations
   - Application d'effets (vitesse, régénération, brillance) selon le type d'interaction
   - Affichage de messages dans le chat Minecraft avec le nom du spectateur
   - Actions personnalisées basées sur les mots-clés dans les commentaires

EXEMPLE CONCRET :
- Un spectateur envoie un cadeau d'une valeur de 100 → Le serveur reçoit l'événement → Minecraft spawn 10 lingots d'or autour du joueur
- Un spectateur fait une donation de 50$ → Le serveur reçoit l'événement → Minecraft spawn 10 diamants et applique un effet de régénération
- Un spectateur envoie 20 likes → Le serveur reçoit l'événement → Minecraft applique un effet de brillance au joueur
- Un spectateur commente "spawn" → Le serveur reçoit l'événement → Minecraft spawn des items automatiquement

TECHNOLOGIES UTILISÉES :
- Backend : Node.js avec Express pour recevoir les webhooks TikTok
- Communication : WebSocket pour la transmission temps réel entre le serveur et Minecraft
- Minecraft : Mod Forge 1.19.2+ qui écoute les événements WebSocket et exécute les actions dans le jeu
```

## 📋 Version courte (si le champ est limité en caractères)

Si le champ a une limite de caractères, utilisez cette version plus courte :

```
PRODUIT : TikTok Live API

SCOPE : live.streaming
- Recevoir les événements en temps réel (cadeaux, donations, likes, commentaires) via webhooks TikTok
- Transmettre ces événements à Minecraft via WebSocket pour déclencher des actions dans le jeu

SCOPE : user.info.basic
- Obtenir le nom d'utilisateur TikTok pour identifier les spectateurs dans les messages Minecraft

FLUX : TikTok Live → Webhook → Serveur Node.js → WebSocket → Mod Minecraft → Actions (spawn items, effets, messages)
```

## ✅ Checklist avant de soumettre

- [ ] GitHub Pages est activé (voir ACTIVATION_GITHUB_PAGES.md)
- [ ] Les 3 URLs sont accessibles dans votre navigateur
- [ ] Le texte d'explication est copié et prêt
- [ ] Vous avez une vidéo de démonstration prête (obligatoire)

## 🔗 URLs à tester

Avant de soumettre, testez ces URLs dans votre navigateur :

1. ✅ https://samymas.github.io/tiktok-minecraft/
2. ✅ https://samymas.github.io/tiktok-minecraft/terms.html
3. ✅ https://samymas.github.io/tiktok-minecraft/privacy.html

Si toutes les pages s'affichent correctement, vous pouvez utiliser ces URLs dans le formulaire !

