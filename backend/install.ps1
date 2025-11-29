# Script d'installation pour PowerShell
Write-Host "Installation des dépendances..." -ForegroundColor Cyan

# Utiliser npm.cmd pour contourner la politique d'exécution
& "$env:ProgramFiles\nodejs\npm.cmd" install

if ($LASTEXITCODE -eq 0) {
    Write-Host "✅ Installation réussie!" -ForegroundColor Green
} else {
    Write-Host "❌ Erreur lors de l'installation" -ForegroundColor Red
    Read-Host "Appuyez sur Entrée pour continuer"
}

