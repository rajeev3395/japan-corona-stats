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
