@echo off
set profile=%1
set directory=%cd%
java -jar %directory%\target\service-feign.jar
echo starting service-feign OK