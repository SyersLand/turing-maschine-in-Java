@echo off
echo ================================
echo   TURING MACHINE RUNNER
echo ================================
echo.

echo 1. Setting up directories...
if not exist bin mkdir bin

echo 2. Compiling with package...
javac -d bin src\turingmaschine\*.java

if errorlevel 1 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo 3. Running...
java -cp bin turingmaschine.TM

echo.
pause