#!/bin/bash
echo "Démarrage du serveur TikTok Live Bridge..."
if [ ! -f .env ]; then
    echo "⚠️  Fichier .env non trouvé!"
    echo "Créez un fichier .env basé sur env.example.txt"
    exit 1
fi
npm start


