# 📝 Créer le fichier .env

## 📍 Emplacement

Le fichier `.env` doit être placé **dans le dossier `backend`** :

```
projet live/
└── backend/
    ├── .env          ← ICI !
    ├── server.js
    ├── package.json
    └── ...
```

## 🚀 Méthode 1 : Copier depuis env.example.txt

### Dans PowerShell :
```powershell
cd backend
Copy-Item env.example.txt .env
```

### Dans CMD :
```cmd
cd backend
copy env.example.txt .env
```

### Ou simplement :
Renommez `env.example.txt` en `.env`

## 🚀 Méthode 2 : Créer manuellement

1. Ouvrez le dossier `backend`
2. Créez un nouveau fichier nommé `.env` (sans extension)
3. Copiez-collez ce contenu :

```env
# Configuration TikTok Live API
TIKTOK_APP_ID=votre_app_id_ici
TIKTOK_APP_SECRET=votre_app_secret_ici
TIKTOK_ACCESS_TOKEN=votre_access_token_ici

# Configuration serveur
PORT=3000
WEBSOCKET_PORT=3001

# Configuration Minecraft
MINECRAFT_SERVER_HOST=localhost
MINECRAFT_SERVER_PORT=25565
```

4. Remplacez les valeurs `votre_...` par vos vraies clés TikTok

## ✅ Vérification

Pour vérifier que le fichier est au bon endroit :

```powershell
cd backend
Test-Path .env
```

Si cela retourne `True`, c'est bon ! ✅

## ⚠️ Important

- Le fichier `.env` est dans `.gitignore` (il ne sera pas commité dans Git)
- Ne partagez JAMAIS votre fichier `.env` publiquement
- Le fichier doit être nommé exactement `.env` (avec le point au début)

