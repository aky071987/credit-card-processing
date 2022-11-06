# credit-card-processing
simple credit card processing full stack application based on react and java

## Technologies

Front-end:
- React
- Axios
- Bootstrap CSS

Back-end:
- Java 11
- Spring Boot
- H2 in-memory Database
- Junit
- Maven

## Getting started
- Clone the repo

To start Application UI on local:
 - cd ccp-frontend
- `npm install` to install all required dependencies
- `npm start` to start the local server 

The ui should run on `http://localhost:3000/`.

To start back-end app locally:

- Using command line

- cd ccp-backend
- mvn clean install
	- this will create application jar in (<ccp-backend>/target)
	- on terminal: java -jar <path_to_ccp-backend>/target/credit-card-processing-1.0.0-SNAPSHOT.jar

- Using IDE	

 - File -> Import -> Existing Maven Project
 - Right Click on the directory and Run as Maven install
 - Open CcpBackendApplication -> Right click -> Run as Java Main Application

Java Application should run on `http://localhost:8080/`.

Swagger ui can be accessed on `http://localhost:8080/swagger-ui/index.html`.