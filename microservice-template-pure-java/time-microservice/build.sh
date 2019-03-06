#!/bin/bash

echo "Building all projects - ignoring :tests for driver and integrationi-tests projects... "
./gradlew clean build -x :time-microservice-driver:test -x :time-microservice-it:test
