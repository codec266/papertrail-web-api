# papertrail-web-api
The Spring Boot backend for the papertrail website
___

## Development Setup
> [!IMPORTANT]
> Update the database password in [application.yml](sbstationeryms/src/main/resources/application.yml) before starting the application.
```
sbstationeryms/src/main/resources/application.yml
```

## Running the Spring Boot application
```powershell
cd sbstationeryms
mvn clean install
mvn spring-boot:run
```

## API Endpoints
### Get All Stationery
```
http://localhost:8080/api/stationery/
```