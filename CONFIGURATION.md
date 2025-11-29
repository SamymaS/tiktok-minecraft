# Guide de Configuration

## 1. Configuration du Backend

### Installation
```bash
cd backend
npm install
```

### Configuration de l'environnement
1. Copiez `.env.example` vers `.env`
2. Remplissez les informations suivantes :

```env
# TikTok Live API - Obtenez ces informations depuis le portail développeur TikTok
TIKTOK_APP_ID=votre_app_id
TIKTOK_APP_SECRET=votre_app_secret
TIKTOK_ACCESS_TOKEN=votre_access_token

# Ports
PORT=3000
WEBSOCKET_PORT=3001
```

### Obtenir les clés API TikTok

📖 **Guide détaillé** : Consultez [GUIDE_TIKTOK_API.md](GUIDE_TIKTOK_API.md) pour un guide complet étape par étape.

**Résumé rapide** :
1. Allez sur [TikTok Developers](https://developers.tiktok.com/)
2. Connectez-vous avec votre compte TikTok
3. Créez une nouvelle application
4. Récupérez votre **App Key** (TIKTOK_APP_ID) et **App Secret** (TIKTOK_APP_SECRET)
5. Activez l'API **TikTok Live** dans les produits
6. Générez un **Access Token** dans les outils
7. Configurez le webhook pour recevoir les événements

### Démarrer le serveur
```bash
npm start
```

Le serveur sera accessible sur `http://localhost:3000`

## 2. Configuration du Mod Minecraft

### Prérequis
- Minecraft 1.19.2
- Forge 43.2.0 ou supérieur
- Java 17

### Compilation du mod

```bash
cd minecraft-mod
./gradlew build
```

Le fichier `.jar` sera généré dans `build/libs/`

### Installation

1. Placez le fichier `.jar` dans le dossier `mods` de votre installation Minecraft
2. Démarrez Minecraft avec Forge

### Configuration du mod

Le mod se connecte automatiquement à `ws://localhost:3001` par défaut.

Pour changer l'adresse du serveur, ajoutez cette propriété JVM lors du lancement :
```
-Dtiktok.server.url=ws://votre-serveur:3001
```

## 3. Configuration du Webhook TikTok

### URL du webhook
```
http://votre-ip-publique:3000/webhook/tiktok
```

⚠️ **Important** : Pour que TikTok puisse envoyer des webhooks, votre serveur doit être accessible depuis Internet. Options :

1. **Utiliser ngrok** (pour les tests) :
   ```bash
   ngrok http 3000
   ```
   Utilisez l'URL fournie par ngrok comme webhook URL

2. **Configurer un reverse proxy** (pour la production) :
   - Utilisez nginx ou Apache
   - Configurez un domaine avec SSL
   - Redirigez vers votre serveur backend

### Configuration dans TikTok

1. Allez dans les paramètres de votre application TikTok
2. Configurez l'URL du webhook
3. Sélectionnez les événements à recevoir :
   - Gifts (Cadeaux)
   - Donations
   - Likes
   - Comments
   - Follows

## 4. Test de la connexion

### Tester le backend
```bash
curl http://localhost:3000/health
```

### Tester l'envoi d'un événement
```bash
curl -X POST http://localhost:3000/test/event
```

### Vérifier la connexion Minecraft
- Démarrez Minecraft avec le mod
- Vérifiez les logs pour voir si la connexion WebSocket est établie
- Vous devriez voir un message dans le chat : "✅ Connecté au serveur TikTok Live"

## 5. Personnalisation des événements

Les événements sont gérés dans `minecraft-mod/src/main/java/com/tiktoklive/events/EventHandler.java`

Vous pouvez modifier :
- Les actions déclenchées par chaque type d'événement
- Les items spawnés
- Les effets appliqués
- Les messages affichés

## Dépannage

### Le mod ne se connecte pas
- Vérifiez que le serveur backend est démarré
- Vérifiez que le port 3001 n'est pas bloqué par le firewall
- Vérifiez les logs du mod dans les logs Minecraft

### Les événements TikTok n'arrivent pas
- Vérifiez que le webhook est correctement configuré dans TikTok
- Vérifiez que votre serveur est accessible depuis Internet
- Vérifiez les logs du serveur backend

### Erreurs de compilation
- Assurez-vous d'avoir Java 17 installé
- Vérifiez que Forge est à la bonne version
- Nettoyez le projet : `./gradlew clean`


