provider "aws" {
  region     = "us-east-1"
}
variable "project" {
  default = "timemicroservice"
}
variable "environment" {
  default = "devtest"
}
variable "cluster_identifier"{
    default = "time-microservice-rds"
}
variable "rdspassword"{
  default = "xxxxxxx"
}