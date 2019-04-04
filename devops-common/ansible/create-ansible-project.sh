#!/bin/bash

mkdir -p roles/common/tasks/     
mkdir -p roles/common/handlers/ 
mkdir -p roles/common/templates/  
mkdir -p roles/common/files/
mkdir -p roles/common/vars/  
mkdir -p roles/common/meta/ 

touch roles/common/tasks/main.yml
touch roles/common/handlers/main.yml
touch roles/common/meta/main.yml
touch roles/common/vars/main.yml
touch main.yml
