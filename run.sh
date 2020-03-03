#!/bin/sh --login -x
sleep 5s
./runappiumserver.sh
osascript -e 'tell application "Terminal" to do script "emulator @$(emulator -list-avds | head -n 1)"'
sleep 15s
java -cp "bin:lib/*" org.testng.TestNG testng.xml
