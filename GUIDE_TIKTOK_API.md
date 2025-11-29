# 🔑 Guide pour obtenir vos clés API TikTok

Ce guide vous explique étape par étape comment obtenir vos informations TikTok nécessaires pour le projet.

## 📋 Informations nécessaires

Vous aurez besoin de :
- `TIKTOK_APP_ID` - L'ID de votre application
- `TIKTOK_APP_SECRET` - Le secret de votre application
- `TIKTOK_ACCESS_TOKEN` - Le token d'accès pour l'API Live

## 🚀 Étapes pour obtenir vos clés

### Étape 1 : Créer un compte développeur TikTok

1. Allez sur [TikTok Developers](https://developers.tiktok.com/)
2. Cliquez sur **"Log in"** en haut à droite
3. Connectez-vous avec votre compte TikTok (le compte avec lequel vous faites vos lives)

### Étape 2 : Créer une application

1. Une fois connecté, allez dans **"My Apps"** ou **"Mes Applications"**
2. Cliquez sur **"Create an app"** ou **"Créer une application"**
3. Remplissez le formulaire :
   - **App Name** : Donnez un nom à votre app (ex: "Minecraft Live Integration")
   - **App Category** : Sélectionnez "Entertainment" ou "Gaming"
   - **Description** : Décrivez brièvement votre projet
   - **Website URL** : Vous pouvez mettre votre site ou une URL temporaire
4. Acceptez les conditions d'utilisation
5. Cliquez sur **"Submit"** ou **"Soumettre"**

### Étape 3 : Obtenir APP_ID et APP_SECRET

1. Une fois l'application créée, vous serez redirigé vers la page de votre app
2. Vous verrez deux informations importantes :
   - **App Key** → C'est votre `TIKTOK_APP_ID`
   - **App Secret** → C'est votre `TIKTOK_APP_SECRET`
   
   ⚠️ **Important** : Cliquez sur "Reveal" pour voir l'App Secret (il est masqué par défaut)

### Étape 4 : Activer l'API TikTok Live

1. Dans la page de votre application, allez dans l'onglet **"Products"** ou **"Produits"**
2. Cherchez **"TikTok Live"** ou **"Live"**
3. Cliquez sur **"Set up"** ou **"Configurer"**
4. Suivez les instructions pour activer l'API Live

### Étape 5 : Obtenir l'ACCESS_TOKEN

Il y a deux méthodes pour obtenir un access token :

#### Méthode 1 : Via l'interface développeur (Recommandé pour les tests)

1. Dans votre application, allez dans **"Tools"** ou **"Outils"**
2. Cherchez **"Generate Access Token"** ou **"Générer un token d'accès"**
3. Sélectionnez les permissions nécessaires :
   - `live.streaming` (pour recevoir les événements live)
   - `user.info.basic` (pour les informations utilisateur)
4. Cliquez sur **"Generate"** ou **"Générer"**
5. Copiez le token généré → C'est votre `TIKTOK_ACCESS_TOKEN`

⚠️ **Note** : Ce token expire généralement après quelques heures. Pour la production, utilisez la méthode 2.

#### Méthode 2 : Via OAuth (Pour la production)

1. Configurez une URL de redirection dans les paramètres de votre app
2. Utilisez le flux OAuth pour obtenir un token de longue durée
3. Consultez la [documentation TikTok OAuth](https://developers.tiktok.com/doc/oauth-user-access-token-management/)

### Étape 6 : Configurer les webhooks (Important !)

1. Dans votre application, allez dans **"Webhooks"** ou **"Webhooks"**
2. Ajoutez votre URL de webhook :
   ```
   http://votre-ip-publique:3000/webhook/tiktok
   ```
   
   ⚠️ **Pour les tests locaux**, utilisez ngrok :
   ```bash
   ngrok http 3000
   ```
   Utilisez l'URL fournie par ngrok (ex: `https://abc123.ngrok.io/webhook/tiktok`)

3. Sélectionnez les événements à recevoir :
   - ✅ **Gift** (Cadeaux)
   - ✅ **Donation** (Donations)
   - ✅ **Like** (Likes)
   - ✅ **Comment** (Commentaires)
   - ✅ **Follow** (Abonnements)

4. Cliquez sur **"Save"** ou **"Enregistrer"**

## 📝 Configuration dans votre projet

Une fois que vous avez toutes les informations :

1. Allez dans le dossier `backend`
2. Créez un fichier `.env` (copiez depuis `env.example.txt`)
3. Remplissez avec vos informations :

```env
TIKTOK_APP_ID=votre_app_key_ici
TIKTOK_APP_SECRET=votre_app_secret_ici
TIKTOK_ACCESS_TOKEN=votre_access_token_ici

PORT=3000
WEBSOCKET_PORT=3001
```

## 🔒 Sécurité

⚠️ **IMPORTANT** :
- Ne partagez **JAMAIS** votre `APP_SECRET` publiquement
- Ne commitez **JAMAIS** le fichier `.env` dans Git (il est déjà dans `.gitignore`)
- Régénérez vos tokens si vous pensez qu'ils ont été compromis

## 🧪 Test de la configuration

Pour tester si vos clés fonctionnent :

1. Démarrez le serveur backend :
   ```bash
   cd backend
   npm start
   ```

2. Vérifiez les logs - vous ne devriez pas voir d'erreurs d'authentification

3. Testez avec un événement de test :
   ```bash
   curl -X POST http://localhost:3000/test/event
   ```

## ❓ Problèmes courants

### "Invalid App ID or Secret"
- Vérifiez que vous avez copié correctement l'APP_ID et APP_SECRET
- Assurez-vous qu'il n'y a pas d'espaces avant/après

### "Token expired"
- Les tokens de test expirent rapidement
- Régénérez un nouveau token dans l'interface développeur
- Pour la production, utilisez OAuth pour obtenir un token de longue durée

### "Webhook not receiving events"
- Vérifiez que votre serveur est accessible depuis Internet (utilisez ngrok pour les tests)
- Vérifiez que les événements sont activés dans les paramètres du webhook
- Vérifiez les logs du backend pour voir si les requêtes arrivent

## 📚 Ressources supplémentaires

- [Documentation TikTok Developers](https://developers.tiktok.com/doc/)
- [Guide TikTok Live API](https://developers.tiktok.com/doc/tiktok-api-v1-webhooks/)
- [OAuth Documentation](https://developers.tiktok.com/doc/oauth-user-access-token-management/)

## 🆘 Besoin d'aide ?

Si vous rencontrez des problèmes :
1. Vérifiez que votre compte TikTok a les permissions nécessaires
2. Assurez-vous que l'API Live est bien activée
3. Consultez les logs d'erreur dans la console du backend

