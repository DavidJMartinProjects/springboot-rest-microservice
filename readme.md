ToDo

add postgres helm
implement caching using redis
write testcases
write readme file

### API Docs
http://localhost:8080/v3/api-docs
http://localhost:8080/v3/api-docs.yaml

/swagger-ui.html

// Done
integrate openapi.yaml
generate interface and model classes 
integrate generated code to controller

// ToDo
add mvn module for the open-api spec
add contract test cases
implement Pagination and Sorting
implement events with rabbitMq (events + write table to topic on update to be read by other services)
build test profile (H2, testcontainer for redis)
build production profile (Postgres, redis embedded or Dockerfile)

