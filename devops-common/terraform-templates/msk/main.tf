resource "aws_msk_cluster" "cluster" {
  cluster_name           = "cluster-test"
  kafka_version          = "2.2.1"
  number_of_broker_nodes = 3

  broker_node_group_info {
    instance_type  = "kafka.m5.large"
    ebs_volume_size = "1000"
    client_subnets = [
      "subnet-id1",
      "subnet-id2",
      "subnet-id2",
    ]
    security_groups = [ "sg-id" ]
  }

  encryption_info {
  }

  tags = {
    foo = "bar"
  }
}