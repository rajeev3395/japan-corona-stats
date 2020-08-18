# japan-corona-stats

## Scope of project
This project is to give the basic details like tested, confirmed, critical cases, etc. prefecture wise
### Swagger
- https://github.com/rajeev3395/swagger/pull/1/files

### Prepare the datasource
-  docker-compose pull mysql &&  docker-compose up -d mysql && gradle flywayMigrate

### Data is served form a DB which already these info.
- table name : corona_details

## Plan for the TDD
   - [x] Test the datasource issue (application will not  build due unsatisfied  dependency)
   - [x] Test the API  endpoint is not available(404 http code test)
   - [x] Add controller 
   - [x] Then fix the test to check 404 http code to 200
   - [x] Add ResponseDTO and Service layer
   - [x] Test the controller layer by mocking service layer
   - [x] Now remove the mocking and  add repository class
   - [x] Add Entity class and init.sql
   - [x] Add flyway task and its dependency
   - [x] Add data not exist exception since test is failed
   - [x] Test the service layer by mocking repo layer
   - [x] Add DBRider dependency
   - [x] Test stats controller after initializing the dataset
   - [x] Finally, check all tests are passed successfully

## Plan for the logging
### Scope
    - Use kafka client to send the app log to a sever
    - Create a kafka consumer to make sure log is on the server
### Steps
    - [x] Set Kafka docker
    - [x] Create a local  topic to publish the message[for testing that consumer is working]
    - [x] Open a consumer console to consume that message
    - [x] Add the log4j2 and Kafka-client lib gradle file, remove logback dependency
    - [x] Set the XML configuration with Kafka being  set as async
    - [x] Run the test once and check it
    - [x] Confirm that message is displayed on the consumer console
