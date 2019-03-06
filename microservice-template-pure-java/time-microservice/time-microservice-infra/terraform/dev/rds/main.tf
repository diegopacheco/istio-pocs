resource "aws_db_instance" "default" {
  allocated_storage    = 10
  storage_type         = "gp2"
  engine               = "mysql"
  engine_version       = "5.7"
  instance_class       = "db.t2.micro"
  name                 = "${var.project}db${var.environment}"
  multi_az             = true
  username             = "root"
  password             = "${var.rdspassword}"
  parameter_group_name = "default.mysql5.7"

  tags {
    Name        = "${var.cluster_identifier}-${var.environment}"
    Environment = "${var.environment}"
    Project     = "${var.project}"
  }
}