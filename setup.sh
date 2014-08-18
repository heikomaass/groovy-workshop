#!/bin/bash

export KOAN_PATH=`pwd`

export PATH=$KOAN_PATH/install/gradle-2.0/bin:$PATH

echo "PATH set for gradle invocation"
echo "  $KOAN_PATH/install/gradle-2.0/bin"
echo 
echo "To run the tests in this project execute"
echo "  gradle clean test"
