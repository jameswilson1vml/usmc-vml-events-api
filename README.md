# USMC VML Events API

A Spring Boot-based REST API for managing USMC VML events.

## Technologies

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- HSQLDB (embedded database)
- OpenAPI/Swagger Documentation
- Lombok
- Maven

## Prerequisites

- Java 17 or higher
- Maven 3.x

## Getting Started

1. Clone the repository
2. Build the project:
   ```bash
   ./mvnw clean install
   ```
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at `http://localhost:8080`

## API Documentation

OpenAPI/Swagger documentation is available at:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Building for Production

To build a production-ready JAR:
```bash
./mvnw clean package
```

The JAR will be created in the `target` directory.

## Docker Support

A Dockerfile is included for containerization. To build and run the container:

```bash
docker build -t usmc-vml-events-api .
docker run -p 8080:8080 usmc-vml-events-api
```

## Development

This project uses:
- Lombok for reducing boilerplate code
- Spring Boot Actuator for monitoring and metrics
- Spring Validation for input validation
- HSQLDB as an embedded database for data persistence
