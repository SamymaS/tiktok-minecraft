# 🎮 TikTok Live → Minecraft Integration

Ce projet permet de connecter vos lives TikTok à Minecraft, déclenchant des événements dans le jeu lorsque les spectateurs envoient des donations ou récompenses.

## 🏗️ Architecture

- **Backend Server** : Serveur Node.js qui reçoit les événements TikTok Live via webhooks
- **Minecraft Mod** : Mod Forge qui écoute les événements et les exécute dans le jeu
- **Communication** : WebSocket pour la communication temps réel entre le backend et Minecraft

## 📋 Prérequis

- Node.js 18+
- Java 17+
- Minecraft avec Forge 1.19.2 ou supérieur
- Compte TikTok avec accès à l'API Live (optionnel pour les tests)

## 🚀 Installation Rapide

### 1. Backend

```bash
cd backend
npm install
# Créez un fichier .env (voir env.example.txt)
npm start
```

### 2. Mod Minecraft

```bash
cd minecraft-mod
./gradlew build
# Le fichier .jar sera dans build/libs/
```

Placez le fichier `.jar` dans votre dossier `mods` de Minecraft.

## 📖 Documentation

- **[QUICK_START.md](QUICK_START.md)** - Guide de démarrage rapide
- **[CONFIGURATION.md](CONFIGURATION.md)** - Guide de configuration détaillé
- **[FORMULAIRE_TIKTOK_APP.md](FORMULAIRE_TIKTOK_APP.md)** - Guide pour remplir le formulaire TikTok
- **[ACTIVATION_GITHUB_PAGES.md](ACTIVATION_GITHUB_PAGES.md)** - Activer GitHub Pages pour les URLs
- **[URLS_TIKTOK_FORMULAIRE.md](URLS_TIKTOK_FORMULAIRE.md)** - URLs prêtes pour le formulaire TikTok

## 🌐 Pages Web (GitHub Pages)

Une fois GitHub Pages activé, les pages seront disponibles à :
- **Page d'accueil** : https://samymas.github.io/tiktok-minecraft/
- **Terms of Service** : https://samymas.github.io/tiktok-minecraft/terms.html
- **Privacy Policy** : https://samymas.github.io/tiktok-minecraft/privacy.html

Voir [ACTIVATION_GITHUB_PAGES.md](ACTIVATION_GITHUB_PAGES.md) pour activer GitHub Pages.

## 🎯 Utilisation

1. Lancez le serveur backend : `cd backend && npm start`
2. Démarrez Minecraft avec le mod installé
3. Le mod se connectera automatiquement au backend (ws://localhost:3001)
4. Testez avec : `curl -X POST http://localhost:3000/test/event`
5. Configurez le webhook TikTok pour recevoir de vrais événements !

## 🎁 Événements Supportés

- **Gifts (Cadeaux)** : Spawn d'items dorés, effet de vitesse pour les gros cadeaux
- **Donations** : Spawn de diamants, effet de régénération
- **Likes** : Effet de brillance pour beaucoup de likes
- **Comments** : Actions basées sur les mots-clés (spawn, speed, etc.)
- **Follows** : Spawn d'items de bienvenue

## ⚙️ Personnalisation

Tous les événements peuvent être personnalisés dans :
`minecraft-mod/src/main/java/com/tiktoklive/events/EventHandler.java`

## 🐛 Dépannage

- **Le mod ne se connecte pas** : Vérifiez que le backend est démarré sur le port 3001
- **Les événements n'arrivent pas** : Vérifiez les logs du backend et du mod
- **Erreurs de compilation** : Assurez-vous d'avoir Java 17 et Forge 1.19.2

## 📝 Notes

- Le mod fonctionne en mode solo et serveur
- Pour recevoir de vrais événements TikTok, vous devez configurer le webhook (voir CONFIGURATION.md)
- Utilisez ngrok pour tester localement avec TikTok

