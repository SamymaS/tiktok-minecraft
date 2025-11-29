# 🚀 Activation de GitHub Pages

Ce guide vous explique comment activer GitHub Pages pour votre repository afin d'avoir accès aux URLs nécessaires pour le formulaire TikTok.

## 📍 URLs une fois activé

Une fois GitHub Pages activé, vous aurez accès à :

- **Page d'accueil** : `https://samymas.github.io/tiktok-minecraft/`
- **Terms of Service** : `https://samymas.github.io/tiktok-minecraft/terms.html`
- **Privacy Policy** : `https://samymas.github.io/tiktok-minecraft/privacy.html`

## ✅ Étapes pour activer GitHub Pages

### Méthode 1 : Via l'interface GitHub (Recommandée)

1. Allez sur votre repository : https://github.com/SamymaS/tiktok-minecraft
2. Cliquez sur **Settings** (Paramètres) en haut du repository
3. Dans le menu de gauche, cliquez sur **Pages**
4. Sous **Source**, sélectionnez :
   - **Branch** : `main`
   - **Folder** : `/docs`
5. Cliquez sur **Save** (Enregistrer)

### Méthode 2 : Via GitHub Actions (Automatique)

Le workflow GitHub Actions est déjà configuré dans `.github/workflows/pages.yml`.

Il se déclenchera automatiquement quand vous :
- Poussez des modifications dans le dossier `docs/` sur la branche `main`
- Ou déclenchez manuellement via l'onglet **Actions**

## ⏱️ Délai d'activation

- GitHub Pages peut prendre **5-10 minutes** pour être activé la première fois
- Les mises à jour suivantes sont généralement instantanées

## 🔍 Vérification

1. Attendez 5-10 minutes après l'activation
2. Visitez : `https://samymas.github.io/tiktok-minecraft/`
3. Vous devriez voir la page d'accueil
4. Testez les liens :
   - `https://samymas.github.io/tiktok-minecraft/terms.html`
   - `https://samymas.github.io/tiktok-minecraft/privacy.html`

## 📝 Utilisation dans le formulaire TikTok

Une fois GitHub Pages activé, utilisez ces URLs dans le formulaire TikTok :

- **Terms of Service URL** : `https://samymas.github.io/tiktok-minecraft/terms.html`
- **Privacy Policy URL** : `https://samymas.github.io/tiktok-minecraft/privacy.html`
- **Web/Desktop URL** : `https://samymas.github.io/tiktok-minecraft/`

## 🐛 Problèmes courants

### "404 Not Found"
- Attendez encore quelques minutes (jusqu'à 10 minutes)
- Vérifiez que le dossier `docs/` contient bien les fichiers HTML
- Vérifiez que GitHub Pages est bien activé dans Settings → Pages

### "Page not found"
- Vérifiez que vous avez bien sélectionné le dossier `/docs` dans les paramètres
- Vérifiez que les fichiers sont bien sur la branche `main`

### "Build failed"
- Allez dans l'onglet **Actions** du repository
- Vérifiez les logs du workflow "Deploy GitHub Pages"
- Les erreurs sont généralement liées à des problèmes de syntaxe dans les fichiers HTML

## 📚 Documentation GitHub Pages

Pour plus d'informations, consultez la [documentation officielle GitHub Pages](https://docs.github.com/en/pages).

