#!/bin/bash

sudo sysctl -w net.ipv4.ip_local_port_range="1025 65535"
echo 300000 | sudo tee /proc/sys/fs/nr_open
echo 300000 | sudo tee /proc/sys/fs/file-max

if [ -z "$1" ]
then
 USERS=1
else
 USERS=$1  
fi

if [ -z "$2" ]
then
 DURING=30
else
 DURING=$2
fi

ulimit -n
echo "Running Gatling with [$USERS] user(s).During [$DURING] second(s). "
./gradlew :time-microservice-st:gatlingRun-com.github.diegopacheco.istio.microservices.time.st.TimeServiceStress -DGATLING_USERS=$USERS -DGATLING_DURING=$DURING
