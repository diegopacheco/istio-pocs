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