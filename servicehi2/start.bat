@echo off
set profile=%1
set directory=%cd%
java -jar %directory%\target\service-hi2.jar
echo starting servicehi2 OK