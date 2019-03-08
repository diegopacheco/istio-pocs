provider "aws" {
  region     = "us-east-1"
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