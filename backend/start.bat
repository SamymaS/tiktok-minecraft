@echo off
echo Démarrage du serveur TikTok Live Bridge...
if not exist .env (
    echo ⚠️  Fichier .env non trouvé!
    echo Créez un fichier .env basé sur env.example.txt
    pause
    exit /b 1
)
npm start


