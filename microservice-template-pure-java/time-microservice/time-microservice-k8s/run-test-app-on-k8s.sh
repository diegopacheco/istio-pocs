#!/bin/bash

curl --silent http://localhost:8080/rest/datetime | jq .
