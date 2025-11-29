# Guide de Démarrage Rapide

## 🚀 Installation Rapide

### 1. Backend (5 minutes)

```bash
cd backend
npm install
```

Créez un fichier `.env` avec :
```env
PORT=3000
WEBSOCKET_PORT=3001
```

Démarrez le serveur :
```bash
npm start
```

✅ Le serveur est maintenant accessible sur `http://localhost:3000`

### 2. Mod Minecraft

#### Option A : Compilation manuelle
```bash
cd minecraft-mod
./gradlew build
```
Le fichier `.jar` sera dans `build/libs/`

#### Option B : Utiliser un mod pré-compilé
(À venir - vous devrez compiler pour l'instant)

### 3. Installation du mod

1. Ouvrez votre dossier Minecraft
2. Placez le fichier `.jar` du mod dans le dossier `mods`
3. Démarrez Minecraft avec Forge 1.19.2

### 4. Test

1. Démarrez le backend
2. Démarrez Minecraft avec le mod
3. Vous devriez voir : "✅ Connecté au serveur TikTok Live" dans le chat
4. Testez avec : `curl -X POST http://localhost:3000/test/event`

## 📡 Configuration TikTok (Optionnel pour les tests)

Pour recevoir de vrais événements TikTok, vous devez :

1. Créer une application sur [TikTok Developers](https://developers.tiktok.com/)
2. Configurer le webhook : `http://votre-ip:3000/webhook/tiktok`
3. Utiliser ngrok pour les tests locaux :
   ```bash
   ngrok http 3000
   ```
   Utilisez l'URL ngrok comme webhook URL

## 🎮 Événements Supportés

- **Gifts** : Spawn d'items dorés
- **Donations** : Spawn de diamants
- **Likes** : Effet de brillance
- **Comments** : Actions basées sur les mots-clés
- **Follows** : Spawn d'items

## ⚙️ Personnalisation

Modifiez `minecraft-mod/src/main/java/com/tiktoklive/events/EventHandler.java` pour changer les actions !


