#!/bin/bash

# Navigate to the src directory
cd src

# Check if the previous command was successful
if [ $? -eq 0 ]; then
    # Compile the Java file, assuming $1 is the filename without extension
    javac -d ../lib/ $1.java

    # Check if the javac command was successful
    if [ $? -eq 0 ]; then
        # Navigate to the lib directory
        cd ../lib

        # Check if the cd command was successful
        if [ $? -eq 0 ]; then
            # Run the Java class
            java $1
            # Navigate back to the parent directory
            cd ..
        fi
    fi
fi
