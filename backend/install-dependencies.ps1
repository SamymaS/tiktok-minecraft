# Script d'installation des dépendances - Contourne la politique PowerShell
Write-Host "🔧 Installation des dépendances..." -ForegroundColor Cyan

# Méthode 1 : Utiliser npm.cmd directement
$npmPath = "C:\Program Files\nodejs\npm.cmd"
if (Test-Path $npmPath) {
    Write-Host "Utilisation de npm.cmd..." -ForegroundColor Yellow
    & $npmPath install
    if ($LASTEXITCODE -eq 0) {
        Write-Host "✅ Installation réussie!" -ForegroundColor Green
        exit 0
    }
}

# Méthode 2 : Changer temporairement la politique
Write-Host "Tentative avec changement de politique d'exécution..." -ForegroundColor Yellow
$originalPolicy = Get-ExecutionPolicy -Scope Process
try {
    Set-ExecutionPolicy -ExecutionPolicy Bypass -Scope Process -Force
    npm install
    if ($LASTEXITCODE -eq 0) {
        Write-Host "✅ Installation réussie!" -ForegroundColor Green
    } else {
        Write-Host "❌ Erreur lors de l'installation" -ForegroundColor Red
    }
} finally {
    Set-ExecutionPolicy -ExecutionPolicy $originalPolicy -Scope Process -Force
}

Read-Host "Appuyez sur Entrée pour continuer"

