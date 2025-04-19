package com.prakash;

import com.prakash.controller.QuestionController;
import com.prakash.controller.StudentController;
import com.prakash.entity.Question;
import com.prakash.entity.Student;
import com.prakash.entity.User;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMain {

    Scanner sc = new Scanner(System.in);
   public AdminMain(User user){

       System.out.println("-----------------Welcome "+user.getName()+"-------------------------");

       while (true)
       {
           System.out.println("Enter your Requirement : ");
           System.out.println("1 Upload Questions by an Excel File");
           System.out.println("2 Upload Student Credentials by an Excel File");
           System.out.println("3 Manage Students");
           System.out.println("4 See All Students");
           System.out.println("5 Set Cutoff");
           System.out.println("6 Show Results");
           System.out.println("7 exit");

           int choice  = Integer.parseInt(sc.nextLine());

           switch (choice){

               case 1 -> uploadQuestions();
               case 2 -> uploadStudentCredentials();
               case 3 -> manageStudents();
               case 4 -> seeAllStudents();
               case 5 -> setCutoff();
               case 6 -> showResults();
               case 7 -> System.exit(0);
               default -> System.out.println("Enter valid choice : ");
           }

       }
    }

    private void uploadQuestions() {

        System.out.println("The Rule for Excel File \n1. first column must contain question \n2.Second column contain option_a for question\n3.Third column contain option_b for question\n4.Fourth column contain option_c for question\n5.Fifth column contain option_d for question\n6.Sixth column contain currect_answer for question\n7.Seventh column contain section for question");
        System.out.println("Enter an Excel File Path : ");
        String path = sc.nextLine();

        //add file data to database
        if(!path.isEmpty())
        {
            try {
                FileInputStream fis = new FileInputStream(path);
                Workbook workBook = WorkbookFactory.create(fis);

                Sheet sheet = workBook.getSheetAt(0);

                List<Question> questions = new ArrayList<>();

                for (Row row : sheet)
                {
                    if(row.getRowNum() == 0) continue; //skip header

                    Question question = new Question();

                    question.setQuestion(row.getCell(0).getStringCellValue());//Question
                    question.setOption_A(row.getCell(1).getStringCellValue());
                    question.setOption_B(row.getCell(2).getStringCellValue());
                    question.setOption_C(row.getCell(3).getStringCellValue());
                    question.setOption_D(row.getCell(4).getStringCellValue());
                    question.setCorrect_answer(row.getCell(5).getStringCellValue());
                    question.setSection(row.getCell(6).getStringCellValue());

                    questions.add(question);

                }


                if(questions.isEmpty())
                {
                    System.out.println("File is empty");
                }
                else if( ! new QuestionController().saveAllQuestions(questions))
                    {
                        System.out.println("Duplicate Questions are not allowed");
                    }
                else
                System.out.println("Questions Successfully uploaded");


                for (Question q : questions)
                {
                    System.out.println(q.getQuestion()+" "+q.getOption_A()+" "+q.getOption_B()+" "+q.getOption_C()+" "+q.getOption_D()+" "+q.getCorrect_answer()+" "+q.getSection());
                    System.out.println("\n\n");
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }



    }

    private void uploadStudentCredentials() {

        System.out.println("The Rule for Excel File \n1. first column must contain student name \n2.Second column contain student email\n3.Third column contain student password\n4.Fourth column contain");
        System.out.println("Enter an Excel File Path : ");
        String path = sc.nextLine();

        //add file data to database
        if(!path.isEmpty())
        {
            try {
                FileInputStream fis = new FileInputStream(path);
                Workbook workBook = WorkbookFactory.create(fis);

                Sheet sheet = workBook.getSheetAt(0);

                List<Student> students = new ArrayList<>();

                for (Row row : sheet)
                {
                    if(row.getRowNum() == 0) continue; //skip header

                    Student student = new Student();

                    student.setId((int)row.getCell(0).getNumericCellValue()); //ID
                    student.setName(row.getCell(1).getStringCellValue());//Name
                    student.setEmail(row.getCell(2).getStringCellValue());//Email
                    student.setPassword(row.getCell(3).getStringCellValue());//Password
                    student.setVerified(true);
                    students.add(student);

                }

                if(students.isEmpty())
                {
                    System.out.println("File is empty");
                }
                else if( ! new StudentController().saveAllStudents(students))
                {
                    System.out.println("Duplicate Email Id are not allowed");
                }
                else System.out.println("Student Credentials Successfully uploaded");


                for (Student s : students){
                    System.out.println(s.getName()+" "+s.getEmail()+" "+s.getPassword());
                    System.out.println("\n\n\n");
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void setCutoff() {

        System.out.println("The Currrent Cutoff is "+Student.examCutoff);

        System.out.println("Enter 1. For Update ");
        int cutoff = Integer.parseInt(sc.nextLine());
        switch (cutoff){
            case 1 -> {
                System.out.println("Enter cutoff for updation : ");
                Student.setExamCutoff(Integer.parseInt(sc.nextLine()));
            }
            default -> System.out.println("Current Cutoff "+Student.examCutoff);
        }
    }

    private void showResults() {

        List<Student> students = new StudentController().getAllStudentsResult();
        if (!students.isEmpty())
        {
            for (Student s : students){
                String result = s.getResult() >= Student.getExamCutoff() ? " PASS " : " FAIL ";
                System.out.println(s.getName()+" "+s.getResult()+" "+result);
            }
        }
        else {
            System.out.println("Student Result are not present");
        }
    }

    private void seeAllStudents() {

       List<Student> students = new StudentController().getAllStudents();
       if (!students.isEmpty())
       {
           for (Student s : students){
               System.out.println(s.getName()+" "+s.getEmail()+" "+s.getPassword());
           }
       }
       else {
           System.out.println("Student are not present");
       }
    }

    private void manageStudents() {

        System.out.println("Enter   \n1. ADD \n2. Delete \n3. Update ");

        switch (Integer.parseInt(sc.nextLine()))
        {
            case 1 -> {
                System.out.println("Enter Student Data : ");
                System.out.println("Enter name : ");
                String name = sc.nextLine();
                System.out.println("Enter email ");
                String email = sc.nextLine();
                System.out.println("Enter password ");
                String password = sc.nextLine();

                List<Student> al = new ArrayList<>();
                al.add(new Student(name,email,password));
                if( ! new StudentController().saveAllStudentsManually(al)){
                    System.out.println("Email must be unique for all studnets");
                }
                else {
                    System.out.println("Student added Successfuly");
                }
            }

            case 2 -> {
                System.out.println("Enter Student mail for delete the student : ");
                System.out.println("Enter email ");
                String email = sc.nextLine();
                if( ! new StudentController().deleteStudentByEmail(email)){
                    System.out.println("Student is not present");
                }
                else {
                    System.out.println("Student deleted Successfuly");
                }
            }

            case 3 -> {

                System.out.println("Enter Student mail for delete the student : ");
                System.out.println("Enter email ");
                String emailforupdation = sc.nextLine();

                Student student = new StudentController().getStudentByEmail(emailforupdation);
                if(student != null)
                {
                    System.out.println("Current Student Data : ");
                    System.out.print("Enter name : "+student.getName()+" ");
                    System.out.print("Enter email "+student.getEmail()+" ");
                    System.out.print("Enter password "+student.getPassword()+" \n");

                    System.out.println("Enter Updated Student Data : ");
                    System.out.println("Enter new name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter new  email ");
                    String email = sc.nextLine();
                    System.out.println("Enter new  password ");
                    String password = sc.nextLine();

                    if( ! new StudentController().updateStudentByEmail(emailforupdation,new Student(name,email,password))){
                        System.out.println("Email must be unique for all studnets");
                    }
                    else {
                        System.out.println("Student updated Successfuly");
                    }
                }
                else
                {
                    System.out.println("Student is not present");
                }


            }

            default -> System.out.println("Enter valid choice");
        }
    }





}
