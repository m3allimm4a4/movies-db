# Movies DB

## Running the app

### Dev run
To run the project execute the following command:
```
.\mvnw spring-boot:run
```

### Prod run
To run the project using prod config execute the following command:
```
.\mvnw spring-boot:run --define spring-boot.run.profiles=prod
```

### Prod build

Run the maven build
```
.\mvnw clean package
```
Add the following environment variable when running the jar file:
```
SPRING_PROFILES_ACTIVE=prod
```
