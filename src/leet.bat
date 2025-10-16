@echo off
if "%~1"=="" (
    echo Usage: makeclass ClassName
    exit /b
)

set CLASSNAME=%~1
set FILE=%CLASSNAME%.java

:: Check if file already exists
if exist "%FILE%" (
    echo WARNING: %FILE% already exists!
    exit /b
)

:: Create the Java class file
echo public class %CLASSNAME% { > %FILE%
echo     public static void main(String[] args) { >> %FILE%
echo         %CLASSNAME% o = new %CLASSNAME%(); >> %FILE%
echo     } >> %FILE%
echo } >> %FILE%

echo %FILE% created!

:: If inside a Git repo, add file
git rev-parse --is-inside-work-tree >nul 2>&1
if %errorlevel%==0 (
    git add "%FILE%"
    echo Added %FILE% to Git staging.
) else (
    echo Not inside a Git repository. Skipped Git add.
)
