echo Cleaning output Directory
mkdir -p output
rm -rf output/*
echo Compiling Java
javac -d output src/main/*.java
echo Running Java Main
java -cp output main.Main