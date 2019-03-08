output "port" {
  value       = "${aws_db_instance.master.port}"
  description = " The database port."
}
output "endpoint" {
  value       = "${aws_db_instance.master.endpoint}"
  description = "The connection endpoint in address:port format."
}

output "instance_address" {
  value       = "${aws_db_instance.master.address}"
  description = "Address of the instance"
}