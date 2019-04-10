#!/bin/bash

alias k=kubectl
k -n dev port-forward $(k -n dev get pod -l app=timemicroservice -o jsonpath='{.items[0].metadata.name}') 8080:8080
