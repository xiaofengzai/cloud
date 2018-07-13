@echo off
set profile=%1
set directory=%cd%
java -jar %directory%\target\service-hi.jar
echo starting servicehi OK