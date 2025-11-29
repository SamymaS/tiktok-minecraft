# 🔧 Solution pour l'erreur PowerShell

Si vous rencontrez l'erreur :
```
Impossible de charger le fichier C:\Program Files\nodejs\npm.ps1, car l'exécution de scripts est désactivée
```

## Solutions rapides

### Solution 1 : Utiliser npm.cmd (Recommandé)
```powershell
npm.cmd install
```

### Solution 2 : Utiliser le script batch
```powershell
.\install.bat
```

### Solution 3 : Changer temporairement la politique d'exécution
```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope Process
npm install
```

### Solution 4 : Utiliser CMD au lieu de PowerShell
Ouvrez CMD (Invite de commandes) et exécutez :
```cmd
cd backend
npm install
```

## Solution permanente (Optionnel)

Si vous voulez permettre l'exécution de scripts npm dans PowerShell de manière permanente :

```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

⚠️ **Note** : Cela permet l'exécution de scripts locaux. Assurez-vous de comprendre les implications de sécurité.

## Scripts fournis

- `install.bat` - Installation via CMD
- `install.ps1` - Installation via PowerShell (utilise npm.cmd)
- `start.bat` - Démarrage du serveur via CMD

