variable "project" {
  default = "timemicroservice"
}
variable "environment" {
  default = "devtest"
}
variable "layer" {
  default = "kubernetes"
}
variable "aws-default-region" {
   default = "us-east-1"
   type = "string"
}