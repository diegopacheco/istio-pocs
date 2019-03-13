#!/bin/bash

export VAULT_ADDR='http://127.0.0.1:8200'

vault kv put secret/test tx.user=? tx.pass=? tx.db=? tx.url=jdbc:mysql://?.us-east-1.rds.amazonaws.com:3306/?
vault kv get secret/test
