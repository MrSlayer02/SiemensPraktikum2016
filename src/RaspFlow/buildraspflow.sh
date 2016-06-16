echo "Removing existing directory icloud from /home/pi"
sudo rm -rf /home/pi/icloud

echo "Removing existing directory icloud from /home/pi/Desktop/GoPiGo/Software/Java/src/com"
sudo rm -rf /home/pi/Desktop/GoPiGo/Software/Java/src/com

echo "Copy icloud folder to /home/pi, then press any key to continue ..."
read t
echo "Continuing"

echo "Copying new folder icloud from /home/pi to /home/pi/Desktop/GoPiGo/Software/Java/src/com"
sudo cp -ar /home/pi/icloud /home/pi/Desktop/GoPiGo/Software/Java/src/com

echo "Compiling source ..."
sudo /home/pi/Desktop/GoPiGo/Software/Java/compile.sh
echo "Done."

echo "Deleting old JAR archive RaspFlow.jar ..."
sudo rm /home/pi/Desktop/GoPiGo/Software/Java/bin/RaspFlow.jar
echo "Done."

cd /home/pi/Desktop/GoPiGo/Software/Java/bin
echo "Creating new RaspFlow.jar file ... Packaging classes ... Packaging Manifest ..."
sudo jar cfm /home/pi/Desktop/GoPiGo/Software/Java/bin/RaspFlow.jar /home/pi/Desktop/GoPiGo/Software/Java/bin/Manifest.txt com/icloud
echo "Done ! Now run RaspFlow.jar with sudo java -jar RaspFlow.jar "
echo ""
