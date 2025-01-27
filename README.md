# Demo Neo4j Project

## Overview
This project is a Spring Boot application that demonstrates the use of Neo4j as a graph database. It includes basic CRUD operations for `PersonNode` entities.

## Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher
- Neo4j database

## Setup
1. Clone the repository:
    ```sh
    git clone https://github.com/aliasthewho/demo_neo4j.git
    cd demo_neo4j
    ```

2. Update the `application.properties` file with your Neo4j database credentials:
    ```properties
    spring.neo4j.uri=bolt://localhost:7687
    spring.neo4j.authentication.username=neo4j
    spring.neo4j.authentication.password=your_password
    ```

3. Build the project:
    ```sh
    mvn clean install
    ```

4. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## Usage
### Creating a Person
To create a new person, send a POST request to `/persons` with the following JSON body:
```json
{
  "name": "John Doe",
  "age": 30
}
