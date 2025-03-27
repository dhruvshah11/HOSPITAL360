@echo off
echo Compiling Java files...

javac -d bin Classes\*.java Frames\*.java Interfaces\*.java "Java Project"\*.java Start.java

echo Creating JAR file...

cd bin
jar cfm ..\HospitalManagement.jar ..\manifest.txt .

cd ..
xcopy /E /I images bin\images
xcopy /E /I Files bin\Files

jar uf HospitalManagement.jar -C bin images -C bin Files

echo Done! Created HospitalManagement.jar
echo You can run the application by double-clicking HospitalManagement.jar or using: java -jar HospitalManagement.jar

pause