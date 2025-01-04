# Jenkins Demo Project

This is a demo project created to integrate Jenkins CI/CD pipeline with a Spring Boot application.

## Technologies

- Java 17
- Spring Boot 3.2.3
- Docker & Docker Compose
- Jenkins
- Ngrok

## Prerequisites

- Docker and Docker Compose
- Java 17 or higher
- Maven
- Ngrok account and auth token

## Installation

1. Clone the project:

```bash
git clone https://github.com/muhammetemrevatan/jenkins-with-spring-boot
cd jenkins-demo
```

2. Copy `.env.example` file to `.env` and add your Ngrok auth token:

```bash
cp .env.example .env
```

3. Start Docker containers:

```bash
docker-compose up -d
```

4. Jenkins access:

- Jenkins UI: http://localhost:8080
- View initial admin password:

```bash
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

5. Ngrok interface:

- http://localhost:4040

## Project Structure

- `src/main/java`: Java source code
- `src/test/java`: Test files
- `Jenkinsfile`: Jenkins pipeline definitions
- `Dockerfile`: Application container configuration
- `docker-compose.yml`: Docker services configuration

## Jenkins Pipeline

The project includes a Jenkins pipeline with the following stages:

- Build
- Test
- Docker image creation
- Container deployment

## License

This project is licensed under the MIT License.
