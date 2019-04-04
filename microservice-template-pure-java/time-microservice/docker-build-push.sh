#!/bin/bash

# 1) option 1 - using gradle + vault - there is no PASS on the file :-)
# ./gradlew pushImage -x :time-microservice-driver:test -x :time-microservice-it:test

# 2) option 2 - using gradle + docker on OS(dont require vault) setup in jenkins.
./gradlew build :time-microservice-war:buildImage -x :time-microservice-driver:test -x :time-microservice-it:test
./gradlew :time-microservice-war:pushDockerImage -x :time-microservice-driver:test -x :time-microservice-it:test