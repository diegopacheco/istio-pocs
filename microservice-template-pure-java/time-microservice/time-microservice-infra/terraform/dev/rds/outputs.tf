output "port" {
  value       = "${aws_db_instance.default.port}"
  description = " The database port."
}
output "endpoint" {
  value       = "${aws_db_instance.default.endpoint}"
  description = "The connection endpoint in address:port format."
}

output "instance_address" {
  value       = "${aws_db_instance.default.address}"
  description = "Address of the instance"
}