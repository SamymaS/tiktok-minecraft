# 📝 Guide : Remplir le formulaire TikTok App Details

Ce guide vous aide à remplir tous les champs du formulaire de création d'application TikTok pour votre projet Minecraft Live.

## 📋 Champs à remplir

### 1. Description * (Obligatoire)

**Exemple pour votre projet** :

```
Application d'intégration en temps réel entre TikTok Live et Minecraft. 
Cette application permet aux streamers de connecter leurs lives TikTok à leur partie Minecraft, 
déclenchant des événements dans le jeu (spawn d'items, effets, etc.) lorsque les spectateurs 
envoient des cadeaux, donations, likes ou commentaires pendant le live. 
L'application utilise l'API TikTok Live pour recevoir les événements en temps réel via webhooks 
et les transmet au jeu Minecraft via WebSocket.
```

**Version courte** :
```
Intégration en temps réel entre TikTok Live et Minecraft permettant aux streamers 
de transformer les interactions de leur audience (cadeaux, donations, likes) en événements 
dans leur partie Minecraft.
```

### 2. Terms of Service URL * (Obligatoire)

✅ **URL GitHub Pages (déjà configurée)** :
```
https://samymas.github.io/tiktok-minecraft/terms.html
```

Les pages sont déjà créées dans le dossier `docs/` du repository. Il suffit d'activer GitHub Pages (voir instructions ci-dessous).

**Template de Terms of Service** (à créer) :
```html
<!DOCTYPE html>
<html>
<head>
    <title>Terms of Service - TikTok Minecraft Integration</title>
</head>
<body>
    <h1>Conditions d'utilisation</h1>
    <p>Cette application permet l'intégration entre TikTok Live et Minecraft.</p>
    <p>En utilisant cette application, vous acceptez de respecter les conditions d'utilisation de TikTok.</p>
    <p>Cette application est fournie "en l'état" sans garantie.</p>
    <p>Dernière mise à jour : [DATE]</p>
</body>
</html>
```

### 3. Privacy Policy URL * (Obligatoire)

✅ **URL GitHub Pages (déjà configurée)** :
```
https://samymas.github.io/tiktok-minecraft/privacy.html
```

Les pages sont déjà créées dans le dossier `docs/` du repository.

**Template de Privacy Policy** :
```html
<!DOCTYPE html>
<html>
<head>
    <title>Privacy Policy - TikTok Minecraft Integration</title>
</head>
<body>
    <h1>Politique de confidentialité</h1>
    <p>Cette application collecte uniquement les données nécessaires à l'intégration TikTok Live :</p>
    <ul>
        <li>Événements de live (cadeaux, donations, likes, commentaires)</li>
        <li>Informations de base du compte TikTok (pour l'authentification)</li>
    </ul>
    <p>Les données sont utilisées uniquement pour déclencher des événements dans Minecraft.</p>
    <p>Aucune donnée n'est stockée de manière permanente.</p>
    <p>Nous ne partageons pas vos données avec des tiers.</p>
    <p>Dernière mise à jour : [DATE]</p>
</body>
</html>
```

### 4. Platforms * (Obligatoire)

Sélectionnez :
- ✅ **Web/Desktop** (car votre backend est un serveur web)

### 5. Web/Desktop URL * (Obligatoire)

✅ **URL GitHub Pages (recommandée)** :
```
https://samymas.github.io/tiktok-minecraft/
```

**Alternative pour les tests avec ngrok** :
```
https://abc123.ngrok.io
```
(Utilisez ngrok si vous voulez tester avec votre serveur local)

**Note** : TikTok peut vérifier cette URL. GitHub Pages est la meilleure option car elle est toujours accessible.

### 6. Explain how each product and scope works * (Obligatoire)

**Exemple pour votre projet** :

```
PRODUIT : TikTok Live API

SCOPE : live.streaming
- Utilisation : Recevoir les événements en temps réel pendant un live TikTok (cadeaux, donations, likes, commentaires, abonnements)
- Fonction : L'application écoute les webhooks TikTok pour capturer les interactions des spectateurs et les transmettre à Minecraft via WebSocket

SCOPE : user.info.basic
- Utilisation : Obtenir les informations de base du compte TikTok (nom d'utilisateur, ID unique)
- Fonction : Identifier l'utilisateur qui envoie les interactions pour les afficher dans le jeu Minecraft

FLUX COMPLET :
1. L'utilisateur démarre un live sur TikTok
2. Les spectateurs envoient des cadeaux, donations, likes ou commentent
3. TikTok envoie ces événements à notre serveur via webhook (endpoint : /webhook/tiktok)
4. Notre serveur traite les événements et les transmet à Minecraft via WebSocket
5. Le mod Minecraft reçoit les événements et déclenche des actions dans le jeu (spawn d'items, effets, messages dans le chat)
```

### 7. Upload demo video * (Obligatoire)

**Ce que TikTok veut voir** :

Un court vidéo (1-2 minutes) montrant :
1. Le démarrage d'un live TikTok
2. La réception d'un cadeau/donation/like
3. L'événement qui se déclenche dans Minecraft
4. Le résultat visible dans le jeu

**Conseils pour la vidéo** :
- Enregistrez votre écran avec OBS ou un autre outil
- Montrez clairement le live TikTok ET Minecraft côte à côte
- Montrez au moins 2-3 types d'événements différents (cadeau, donation, like)
- Ajoutez des sous-titres ou annotations pour expliquer ce qui se passe
- Durée recommandée : 1-2 minutes maximum

**Structure suggérée** :
```
0:00-0:10 - Introduction : "Voici l'intégration TikTok Live avec Minecraft"
0:10-0:30 - Démarrage du live TikTok et connexion du mod Minecraft
0:30-1:00 - Démonstration : Réception d'un cadeau → Spawn d'items dans Minecraft
1:00-1:30 - Démonstration : Réception d'une donation → Spawn de diamants
1:30-2:00 - Conclusion : Vue d'ensemble du système
```

## 🎬 Créer rapidement les pages Terms et Privacy

### Méthode rapide avec GitHub Pages

1. Créez un nouveau repository GitHub (ex: `tiktok-minecraft-pages`)
2. Créez deux fichiers :
   - `terms.html` (avec le template ci-dessus)
   - `privacy.html` (avec le template ci-dessus)
3. Activez GitHub Pages dans les settings du repo
4. Vos URLs seront :
   - `https://votre-username.github.io/tiktok-minecraft-pages/terms.html`
   - `https://votre-username.github.io/tiktok-minecraft-pages/privacy.html`

### Méthode avec Netlify Drop

1. Allez sur https://app.netlify.com/drop
2. Créez un dossier avec `terms.html` et `privacy.html`
3. Glissez le dossier sur la page
4. Vous obtenez une URL automatiquement

## 📝 Résumé des URLs à préparer

Avant de remplir le formulaire, préparez :

1. ✅ **Terms of Service URL** : `https://votre-site.com/terms.html`
2. ✅ **Privacy Policy URL** : `https://votre-site.com/privacy.html`
3. ✅ **Web/Desktop URL** : `https://votre-domaine.com` ou `https://abc123.ngrok.io`
4. ✅ **Demo Video** : Vidéo YouTube ou autre hébergement

## ⚠️ Notes importantes

- Tous les champs marqués * sont **obligatoires**
- TikTok peut prendre plusieurs jours pour approuver votre application
- Assurez-vous que toutes les URLs sont accessibles publiquement
- La vidéo doit montrer un flux complet de bout en bout

## 🆘 Si vous n'avez pas encore de site web

**Solution temporaire pour les tests** :
- Utilisez GitHub Pages (gratuit et rapide)
- Ou créez un site simple sur Netlify/Vercel (gratuit)
- Pour la vidéo, utilisez YouTube (non listée) ou un autre hébergement vidéo

Une fois votre application approuvée, vous pourrez obtenir vos clés API !

