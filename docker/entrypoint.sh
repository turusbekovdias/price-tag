#!/bin/bash

# Find class containing name "*Application.class"
APP_PATH=$(cd app && find -type f -name "*Application.class" | sed -e "s/.class//" | sed -e "s/.\///1");
# Use that class to start application
java -XX:TieredStopAtLevel=1 -Djava.security.egd=file:/dev/./urandom -cp app:app/lib/* $APP_PATH
