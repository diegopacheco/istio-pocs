#!/bin/bash

TFVARS="rdspassword=yyyyyy"

terraform init 
terraform plan  -var $TFVARS
terraform apply -var $TFVARS
