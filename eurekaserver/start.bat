@echo off
set profile=%1
set directory=%cd%
java -jar %directory%\target\eurekaserver.jar
echo starting eurekaserver OK