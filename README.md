# ibf-exam-system-console
A console-based Java + MySQL project for an online examination system built using the MVC layered architecture. Includes admin and user functionalities with CLI-based interaction.


# IBF Online Examination System - Console Based

This is a console-based online examination system developed using Java and MySQL, following the MVC (Model-View-Controller) layered architecture. It simulates a basic online test platform where users can log in, take exams, and view results via the command line interface.

## 🔧 Technologies Used
- Java (Core)
- MySQL
- JDBC
- MVC Architecture

## 🎯 Features
- User and Admin login system
- Admin can:
  - Create exams
  - Add questions
  - View student results
- Users can:
  - Take exams
  - View their results
- Fully console-based interface

## 🗃️ Project Structure (MVC)
- `Model` → Handles database operations (e.g., Question, User, Exam models)
- `View` → Console-based UI (printed menus, input/output)
- `Controller` → Handles logic between model and view

## 🛠️ How to Run
1. Clone the repository.
2. Create the database using the provided `.sql` file.
3. Update database connection settings in the code.
4. Compile and run the `Main` class.

```bash
javac Main.java
java Main

