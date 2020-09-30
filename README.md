With Docker:
        1.1. Compiler component with maven, run the command: mvn clean install -Dmaven.test.skip=true
        1.2. Run the command: docker-compose up --build (Docker must be installed).
        1.3. Run the postman collections

Springboot/Maven:
    NOTE: To run with this option it is necessary to have a PostgreSQL database with a database called "testtrycore"
          and change the connection string to the database in the application.properties file so that the scripts 
          can be executed table creation.
    2.1. Compile the project with the command: mvn clean install
    2.2. Move to the root folder of the project: cd C:\Users\user\testTrycore\target
    2.3. Run the following command: mvn spring-boot:run
    

Enpoint to consume service:

Type: POST
localhost:8081/api/person

Request example:
{
    "age": 26,
    "fullName": "Albert Medina",
    "idNumber": 881675,
    "height": 1.75,
    "weight": 100,
    "gender": 1,
    "birthDate": "1993-10-22"
}

Response:
{
    "id": 3,
    "age": 73,
    "fullName": "Alvaro Medina",
    "idNumber": 3348007,
    "height": 1.75,
    "weight": 80.0,
    "gender": 1,
    "birthDate": "1947-09-22T00:00:00.000+00:00",
    "countView": 0
}

Type: POST
localhost:8081/api/planet

Request example:
{
    "name": "Tierra"
}

Response:
{
    "id": 1,
    "name": "Tierra",
    "countView": 0
}


    

