# Web Application for Quiz Generation

This repository contains the course project for the **Master's in Professional Software Engineering** at the **Polytechnic University of Tirana**. The project is a web application for generating and managing quizzes, featuring user authentication, quiz management, and score tracking. 

## Project Overview

The objective of this project is to develop a web-based quiz platform where users can register, log in, take quizzes, and view their quiz history. The application is built using **Servlets**, **JSP**, and **JSF** technologies, along with **Remote Method Invocation (RMI)** for server-side quiz functionalities.

### Main Features:
- **User Registration and Authentication** using Servlets and sessions.
- **Quiz Management** allowing administrators to add, edit, or delete quizzes.
- **Quiz Participation** with JSF for rendering questions and tracking user progress.
- **Score Calculation and History** stored in a relational database.
- **Remote Method Invocation (RMI)** for quiz-related functionalities.

### Technologies Used:
- **Java Servlets** for user authentication and session management.
- **JSP** and **JSF** for rendering dynamic quiz content.
- **RMI** for handling server-side quiz-related operations.
- **Oracle** for storing user data, quizzes, and results.

## Project Specifications

### 1. User Authentication (Servlets and JSP)
- **Registration** with fields: username, password, email.
- **Login** functionality using sessions.
- **Profile Page**: Users can view and update their personal information.

### 2. Quiz Management (Servlets and JSP)
- **Multiple-choice quizzes** on various topics.
- Display a list of available quizzes.
- **Admin Role**: Administrators can add, edit, or delete quizzes.

### 3. Quiz Participation (Servlets, JSP, JSF)
- Quizzes are displayed one question at a time using **JSF**.
- Track quiz progress using sessions.
- **Radio buttons** for selecting answers.
- Navigation controls to move between questions.

### 4. Scoring and History (Servlets and JSP)
- Calculate and display scores at the end of the quiz.
- Save quiz results in a relational database (Results table).
- Display the user's quiz history, including dates and scores.

### 5. Remote Method Invocation (RMI)
- Implement an RMI component for:
  - Retrieving quiz questions from the server.
  - Submitting quiz results.
- Integrate RMI calls into Servlets, JSP, or JSF pages.

### 6. Database Design
- Create a relational database with tables:
  - **Users**: Stores user details.
  - **Quizzes**: Stores quiz metadata.
  - **Questions**: Stores quiz questions.
  - **Options**: Stores answer options for each question.
  - **Results**: Stores quiz results and scores.
- Use **Java classes** to represent each table.
- Implement a **database management class** to handle connections, queries, and updates.
- Use **prepared statements** for secure and efficient database queries.

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/elgalika/quizApplicationServletJava
   cd quizApplicationServletJava
   ```

2. Set up the database:
   - Use the `database.sql` file to create the necessary tables for users, quizzes, questions, and results.

3. Build and run the application:
   ```bash
   mvn clean install
   mvn tomcat7:run
   ```

4. Access the application:
   - Web platform: `http://localhost:8080`
   - Admin panel: Requires login with an admin account.

## Advanced Features

- **Timer** for quizzes, displaying the time taken for each quiz.

## Images

- **User Session**

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/f22ff059-3479-49cb-a7d2-bdae5b4e2ae2)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/f340fc26-2a04-4878-840d-f8357efbfe32)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/988d688b-4ca5-46a2-841e-39f2b25d5e58)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/0485496e-3ce3-49fd-bb0b-afaff4c5b605)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/439dc80b-759d-4956-af88-9c0054bb91b7)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/ab588d45-e889-4ca8-8fb7-f0e08f8fcbc9)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/cbb04515-a4f4-48fd-86ee-d9f9ca63f51b)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/a649ed3d-1e61-4131-9229-0544edb60a93)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/907bb800-df71-4fed-8841-79e5831a829f)

- **Admin Session**

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/cde4391a-b4e4-4e03-b1c9-a5fbd4674b8d)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/0350c2e9-0a7c-48e3-a797-32db8372834b)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/f3c95b58-8949-4bde-b66c-0c601e2f4f50)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/1b9a8256-d50f-47d2-a2b7-98caef5acde6)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/b289f52e-4e74-4464-ab0d-203b5a3fb7e9)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/046b7f50-9d23-4505-b715-6183eedc914f)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/6f157b9c-f511-4622-a43a-dc43812900ae)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/82016637-0c2e-4e90-a074-9596535aace3)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/c4315637-9019-4f7f-9ec7-a39107aeea3e)

![image](https://github.com/elgalika/quizApplicationServletJava/assets/150843883/302ae6ff-df50-4663-86cf-3683f2e5d752)

