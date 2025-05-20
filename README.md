# Web Quiz Engine

In the Internet, you can often find sites where you need to answer some questions. It can be educational sites, sites with psychological tests, job search services, or just entertaining sites like web quests. The common thing for them is the ability to answer questions (or quizzes) and then see some results. In this project, you will create a complex web service and learn about REST API, an embedded database, security, and other technologies. If you would like to continue the project, you could develop a web or mobile client for this web service on your own.<br/>
A Spring Boot application for creating, managing, and solving quizzes. Users can register, solve quizzes, and track their completed quizzes. 

## Features

- User registration and authentication
- Create, update, and delete quizzes
- Solve quizzes and get instant feedback
- Track completed quizzes with pagination

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Gradle

## Project Structure

- `src/engine/entity` - JPA entities
- `src/engine/repository` - Spring Data repositories
- `src/engine/service` - Business logic
- `src/engine/controller` - REST controllers

## Running the Application

1. Clone the repository.
2. Navigate to the project root.
3. Build the project:gradlew build
4. Run the application:gradlew bootRun

## Usage

- Access the API at `http://localhost:8889/api/quizzes`
- Use tools like Postman to interact with the endpoints

<br/><br/>Learn more at <a href="https://hyperskill.org/projects/91?utm_source=ide&utm_medium=ide&utm_campaign=ide&utm_content=project-card">https://hyperskill.org/projects/91</a>

Here's the link to the project: https://hyperskill.org/projects/91

Check out my profile: https://hyperskill.org/profile/527332546
