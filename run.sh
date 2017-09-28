echo Cleaning output Directory
rm -rf output
echo Compiling Java
javac -d output src/main/*.java
echo Running Java Main
java -cp output main.Main