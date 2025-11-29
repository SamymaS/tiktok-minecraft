# 🔑 Guide Rapide : Obtenir vos clés TikTok

## 📍 Où trouver vos informations

### 1. TIKTOK_APP_ID et TIKTOK_APP_SECRET

1. Allez sur **https://developers.tiktok.com/**
2. Connectez-vous avec votre compte TikTok
3. Cliquez sur **"My Apps"** → **"Create an app"**
4. Remplissez le formulaire et créez l'application
5. Sur la page de votre app, vous verrez :
   - **App Key** → C'est votre `TIKTOK_APP_ID`
   - **App Secret** → Cliquez sur "Reveal" pour voir → C'est votre `TIKTOK_APP_SECRET`

### 2. TIKTOK_ACCESS_TOKEN

1. Dans votre application TikTok, allez dans **"Tools"** (Outils)
2. Cliquez sur **"Generate Access Token"**
3. Sélectionnez les permissions :
   - ✅ `live.streaming`
   - ✅ `user.info.basic`
4. Cliquez sur **"Generate"**
5. Copiez le token → C'est votre `TIKTOK_ACCESS_TOKEN`

### 3. Configuration du Webhook

1. Dans votre app, allez dans **"Webhooks"**
2. Ajoutez l'URL : `http://votre-ip:3000/webhook/tiktok`
   - Pour les tests locaux, utilisez **ngrok** : `ngrok http 3000`
3. Activez les événements : Gift, Donation, Like, Comment, Follow

## 📝 Configuration

Créez un fichier `.env` dans le dossier `backend` :

```env
TIKTOK_APP_ID=votre_app_key_ici
TIKTOK_APP_SECRET=votre_app_secret_ici
TIKTOK_ACCESS_TOKEN=votre_token_ici

PORT=3000
WEBSOCKET_PORT=3001
```

## ⚠️ Important

- Ne partagez JAMAIS votre App Secret
- Le token expire après quelques heures (pour les tests)
- Pour la production, utilisez OAuth pour un token de longue durée

## 📖 Guide complet

Pour plus de détails, consultez [GUIDE_TIKTOK_API.md](../GUIDE_TIKTOK_API.md)

