@echo off
echo Cleaning output Directory
rm -rf output/*
echo Compiling Java
javac -d output src/main/*.java