@echo off
cd src
if %ERRORLEVEL% == 0 (
    javac -d ../lib/ %1.java
    if %ERRORLEVEL% == 0 (
        cd ../lib
        if %ERRORLEVEL% == 0 (
            java %1
            cd ..
        )
    )
)