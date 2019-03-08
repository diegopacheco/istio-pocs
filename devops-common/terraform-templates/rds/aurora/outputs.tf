output "endpoint" {
  value       = "${aws_db_instance.master.endpoint}"
  description = "The connection endpoint in address:port format."
}
output "instance_address" {
  value       = "${aws_rds_cluster.default.address}"
  description = "Address of the instance"
}