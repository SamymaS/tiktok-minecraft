# 📦 Guide d'Installation - Résolution du problème PowerShell

## ⚠️ Problème rencontré

Si vous voyez cette erreur dans PowerShell :
```
Impossible de charger le fichier C:\Program Files\nodejs\npm.ps1, car l'exécution de scripts est désactivée
```

## ✅ Solutions (dans l'ordre de préférence)

### Solution 1 : Utiliser le script batch (RECOMMANDÉ)

**Double-cliquez simplement sur** `backend/install.bat`

Ou dans PowerShell :
```powershell
cd backend
.\install.bat
```

### Solution 2 : Utiliser CMD (Invite de commandes)

1. Ouvrez **CMD** (pas PowerShell)
2. Naviguez vers le dossier :
   ```cmd
   cd "C:\Users\SamyB\dev\projet live\backend"
   ```
3. Installez :
   ```cmd
   npm install
   ```

### Solution 3 : Utiliser npm.cmd dans PowerShell

Dans PowerShell, utilisez `.cmd` :
```powershell
cd backend
npm.cmd install
```

### Solution 4 : Changer temporairement la politique PowerShell

Dans PowerShell, exécutez :
```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope Process
npm install
```

Cette commande change la politique **uniquement pour cette session** PowerShell.

### Solution 5 : Changer la politique de manière permanente (AVANCÉ)

⚠️ **Attention** : Cela change la politique pour votre utilisateur de manière permanente.

```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

Puis :
```powershell
npm install
```

## 🚀 Après l'installation

Une fois les dépendances installées, vous pouvez démarrer le serveur :

```powershell
cd backend
npm start
```

Ou utilisez le script :
```powershell
.\start.bat
```

## 📝 Vérification

Pour vérifier que l'installation a réussi, vérifiez que le dossier `node_modules` existe :

```powershell
Test-Path backend\node_modules
```

Si cela retourne `True`, l'installation a réussi ! ✅

