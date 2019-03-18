resource "aws_db_instance" "master" {
  identifier           = "${var.project}db${var.environment}"
  name                 = "${var.project}db${var.environment}"
  allocated_storage    = 10
  storage_type         = "gp2"
  engine               = "mysql"
  engine_version       = "5.7"
  instance_class       = "db.t2.micro"
  multi_az             = true
  username             = "root"
  password             = "${var.rdspassword}"
  parameter_group_name = "default.mysql5.7"
  skip_final_snapshot  = true
  final_snapshot_identifier = "Ignore"
  backup_retention_period = 1 

  tags {
    name        = "${var.cluster_identifier}-${var.environment}"
    cloudenv    = "${var.environment}"
    project     = "${var.project}"
    layer       = "${var.layer}"
  }
}