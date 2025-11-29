@echo off
echo ========================================
echo Installation des dependances Node.js
echo ========================================
echo.

cd /d "%~dp0"

echo Verification de Node.js...
where npm >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERREUR: npm n'est pas trouve dans le PATH
    echo Assurez-vous que Node.js est installe
    pause
    exit /b 1
)

echo Node.js trouve!
echo.
echo Installation des packages...
echo.

call npm.cmd install

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo ✅ Installation reussie!
    echo ========================================
    echo.
    echo Vous pouvez maintenant lancer le serveur avec:
    echo   npm start
    echo   ou
    echo   start.bat
    echo.
) else (
    echo.
    echo ========================================
    echo ❌ Erreur lors de l'installation
    echo ========================================
    echo.
)

pause

