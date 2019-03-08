provider "aws" {
  region = "us-east-1"
}
variable "azs" {
  type = "list"

  default = [
    "us-east-1a",
    "us-east-1b",
    "us-east-1c",
  ]
}
variable "project" {
  default = "timemicroservice"
}
variable "environment" {
  default = "devtest"
}
variable "layer" {
  default = "data"
}
variable "cluster_identifier"{
    default = "time-microservice-rds"
}
variable "rdspassword"{
  default = "xxx"
}