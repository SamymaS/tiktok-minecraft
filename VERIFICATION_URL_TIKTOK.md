# ✅ Vérification de l'URL TikTok

TikTok demande de vérifier que vous contrôlez l'URL en téléchargeant un fichier et en le plaçant sur votre site.

## 📋 Étapes de vérification

### Étape 1 : Télécharger le fichier de vérification

1. Dans le formulaire TikTok, cliquez sur le bouton de téléchargement
2. Le fichier sera téléchargé (ex: `tiktokXaRmZ1i4K0PmOQhKvyoPFZDk3aGD1eWU.txt`)
3. Notez le nom exact du fichier

### Étape 2 : Placer le fichier sur GitHub Pages

Vous devez placer le fichier dans le dossier `docs/` de votre repository pour qu'il soit accessible via GitHub Pages.

**Option A : Via GitHub (Recommandé)**

1. Allez sur votre repository : https://github.com/SamymaS/tiktok-minecraft
2. Naviguez vers le dossier `docs/`
3. Cliquez sur **"Add file"** → **"Upload files"**
4. Glissez le fichier `.txt` téléchargé
5. Cliquez sur **"Commit changes"**

**Option B : Via votre ordinateur local**

1. Placez le fichier téléchargé dans le dossier `docs/` de votre projet local
2. Commitez et poussez vers GitHub :
   ```bash
   git add docs/tiktokXaRmZ1i4K0PmOQhKvyoPFZDk3aGD1eWU.txt
   git commit -m "Add TikTok verification file"
   git push origin main
   ```

### Étape 3 : Vérifier l'accessibilité

Attendez 1-2 minutes que GitHub Pages se mette à jour, puis testez l'URL dans votre navigateur :

```
https://samymas.github.io/tiktok-minecraft/tiktokXaRmZ1i4K0PmOQhKvyoPFZDk3aGD1eWU.txt
```

Vous devriez voir le contenu du fichier texte.

### Étape 4 : Cliquer sur "Verify" dans TikTok

Une fois que le fichier est accessible, retournez dans le formulaire TikTok et cliquez sur le bouton **"Verify"**.

## ⚠️ Notes importantes

- **URL avec slash final** : Si TikTok demande `https://samymas.github.io/tiktok-minecraft/terms.html/`, cela signifie qu'il cherche le fichier dans un sous-dossier. Dans ce cas, créez un dossier `terms.html` dans `docs/` et placez le fichier dedans.
- **URL sans slash** : Si TikTok demande juste l'URL de base, placez le fichier directement dans `docs/`.
- Le fichier doit être accessible publiquement (pas de protection par mot de passe).

## 🔍 Vérification de l'URL exacte

Regardez attentivement l'URL demandée par TikTok :

- Si c'est : `https://samymas.github.io/tiktok-minecraft/terms.html/` (avec slash final)
  → Créez `docs/terms.html/tiktokXaRmZ1i4K0PmOQhKvyoPFZDk3aGD1eWU.txt`
  
- Si c'est : `https://samymas.github.io/tiktok-minecraft/` (sans chemin spécifique)
  → Placez `docs/tiktokXaRmZ1i4K0PmOQhKvyoPFZDk3aGD1eWU.txt`

## 🐛 Si la vérification échoue

1. Vérifiez que le fichier est bien dans le bon dossier
2. Vérifiez que GitHub Pages est activé
3. Attendez 5-10 minutes pour que GitHub Pages se mette à jour
4. Testez l'URL directement dans votre navigateur
5. Vérifiez que le nom du fichier est exactement le même (sensible à la casse)

