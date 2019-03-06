output "instance_address" {
  value       = "${aws_db_instance.default.address}"
  description = "Address of the instance"
}