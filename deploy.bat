 call mvn clean install -Dmaven.test.skip
 call mvn package docker:build -Dmaven.test.skip
 call docker run -p 8080:8080 --link=microservicehomework_mshm_cc_1 -t microservice-homework/microservice.homework