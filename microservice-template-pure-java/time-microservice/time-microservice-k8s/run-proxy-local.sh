#!/bin/bash

k=$(which kubectl)
name=$($k -n dev get pod -l app=timemicroservice -o jsonpath='{.items[0].metadata.name}')
$k -n dev port-forward $name 8080:8080
