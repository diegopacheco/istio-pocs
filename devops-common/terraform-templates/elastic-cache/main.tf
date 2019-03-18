module "redis" "default" {
  source                  = "git::https://github.com/cloudposse/terraform-aws-elasticache-redis.git?ref=master"
  name                    = "redis-cluster-${var.project}-${var.environment}-${var.aws_region}"
  stage                   = "dev"
  cluster_size            = "1"
  port                    = 22122
  instance_type           = "cache.t2.micro"
  engine_version          = "4.0.10"
  availability_zones      = "${var.azs}"
  automatic_failover      = "false"
  auth_token              = "${random_string.auth_token.result}"
  replication_group_id    = "ecr-rep-group-1"
}

resource "aws_elasticache_replication_group" "default" {
  replication_group_id          = "ecr-rep-group-1"
  replication_group_description = "ecr-rep-group-1"
  number_cache_clusters         = 1
  node_type                     = "cache.t2.micro"
}