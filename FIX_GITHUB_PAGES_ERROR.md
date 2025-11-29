# 🔧 Résolution de l'erreur GitHub Pages

## ❌ Erreur rencontrée

```
Error: Get Pages site failed. Please verify that the repository has Pages enabled 
and configured to build using GitHub Actions
```

## 🔍 Cause

Cette erreur se produit parce que **GitHub Pages n'est pas encore activé** dans les paramètres du repository. Le workflow GitHub Actions nécessite que GitHub Pages soit activé manuellement en premier.

## ✅ Solution : Activer GitHub Pages manuellement

### Étape 1 : Activer GitHub Pages via l'interface

1. Allez sur votre repository : https://github.com/SamymaS/tiktok-minecraft
2. Cliquez sur **Settings** (Paramètres) en haut du repository
3. Dans le menu de gauche, cliquez sur **Pages**
4. Sous **Source**, sélectionnez :
   - **Deploy from a branch** (si ce n'est pas déjà sélectionné)
   - **Branch** : `main`
   - **Folder** : `/docs`
5. Cliquez sur **Save** (Enregistrer)

### Étape 2 : Attendre l'activation

- GitHub Pages peut prendre **5-10 minutes** pour être activé
- Vous verrez un message vert "Your site is live at..." une fois activé

### Étape 3 : Vérifier l'activation

1. Retournez dans **Settings → Pages**
2. Vous devriez voir :
   - ✅ "Your site is published at https://samymas.github.io/tiktok-minecraft/"
   - ✅ "Source" configuré sur "Deploy from a branch" avec "main" et "/docs"

### Étape 4 : Relancer le workflow

Une fois GitHub Pages activé :

1. Allez dans l'onglet **Actions** du repository
2. Trouvez le workflow "Deploy GitHub Pages"
3. Cliquez sur **Run workflow** (ou attendez le prochain push)

## 🔄 Alternative : Utiliser la méthode branch (sans Actions)

Si vous préférez ne pas utiliser GitHub Actions, vous pouvez utiliser la méthode branch directement :

1. Allez dans **Settings → Pages**
2. Sous **Source**, sélectionnez :
   - **Deploy from a branch**
   - **Branch** : `main`
   - **Folder** : `/docs`
3. Cliquez sur **Save**

Cette méthode fonctionne sans GitHub Actions et déploie automatiquement à chaque push sur la branche main.

## 📝 Vérification finale

Une fois activé, testez ces URLs :

- ✅ https://samymas.github.io/tiktok-minecraft/
- ✅ https://samymas.github.io/tiktok-minecraft/terms.html
- ✅ https://samymas.github.io/tiktok-minecraft/privacy.html

## 🐛 Si l'erreur persiste

1. **Vérifiez les permissions** :
   - Le repository doit être public OU
   - Vous devez avoir les permissions d'admin sur le repository

2. **Vérifiez que le dossier docs existe** :
   - Le dossier `docs/` doit contenir au moins un fichier HTML
   - Les fichiers doivent être sur la branche `main`

3. **Attendez plus longtemps** :
   - Parfois GitHub prend jusqu'à 15 minutes pour activer Pages

4. **Vérifiez les logs** :
   - Allez dans **Actions** → Cliquez sur le workflow → Vérifiez les logs détaillés

## 📚 Documentation

- [Documentation GitHub Pages](https://docs.github.com/en/pages)
- [GitHub Actions pour Pages](https://docs.github.com/en/pages/getting-started-with-github-pages/configuring-a-publishing-source-for-your-github-pages-site#publishing-with-a-custom-github-actions-workflow)

