resource "aws_rds_cluster" "default" {
  cluster_identifier                  = "${var.project}db${var.environment}"
  engine                              = "aurora-mysql"
  engine_version                      = "5.7.12"
  database_name                       = "${var.project}db${var.environment}"
  master_username                     = "root"
  master_password                     = "${var.rdspassword}"
  deletion_protection                 = false
  backup_retention_period             = "1"  
  replica_count                       = 1
  instance_class                      = "db.t2.medium"
  skip_final_snapshot                 = true

  tags {
    name        = "${var.cluster_identifier}-${var.environment}"
    cloudenv    = "${var.environment}"
    project     = "${var.project}"
    layer       = "${var.layer}"
  }
}

resource "aws_rds_cluster_instance" "default" {
  count = "${var.replica_scale_enabled ? var.replica_scale_min : var.replica_count}"

  identifier                      = "${var.project}db${var.environment}-${count.index + 1}"
  cluster_identifier              = "${aws_rds_cluster.default.id}"
  engine                          = "aurora-mysql"
  engine_version                  = "5.7.12"
  instance_class                  = "db.t2.medium"

  tags {
    name        = "${var.cluster_identifier}-${var.environment}"
    cloudenv    = "${var.environment}"
    project     = "${var.project}"
    layer       = "${var.layer}"
  }
}
