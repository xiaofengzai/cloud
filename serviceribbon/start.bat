@echo off
set profile=%1
set directory=%cd%
java -jar %directory%\target\service-ribbon.jar
echo starting serviceribbon OK