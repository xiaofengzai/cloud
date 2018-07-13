@echo off
set profile=%1
set directory=%cd%
set path=D:\soft\java\bin
call %directory%\eurekaserver\target\start.bat
call %directory%\servicehi\target\start.bat
call %directory%\servicehi2\target\start.bat
call %directory%\serviceribbon\target\start.bat
echo starting OK