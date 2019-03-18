output "auth_token" {
  value = "${random_string.auth_token.result}"
}