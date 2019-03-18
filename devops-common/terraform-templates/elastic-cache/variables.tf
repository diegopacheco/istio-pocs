resource "random_string" "auth_token" {
  length = 64
  special = false
}

provider "aws" {
  region = "${var.aws_region}"
}

variable "aws_region"{
  type    = "string"
  default = "us-east-1"
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