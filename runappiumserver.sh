#!/bin/sh
osascript -e 'tell application "Terminal" to do script "node /usr/local/lib/node_modules/appium/build/lib/main.js --address 0.0.0.0 --port 4723 --log-timestamp --local-timezone"'
