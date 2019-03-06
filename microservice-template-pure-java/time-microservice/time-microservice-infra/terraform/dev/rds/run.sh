#!/bin/bash

TFVARS="rdspassword=ChAnGEME1"

terraform init 
terraform apply -input=false -var $TFVARS -auto-approve
