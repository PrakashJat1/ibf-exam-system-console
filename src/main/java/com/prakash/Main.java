package com.prakash;

import com.prakash.controller.StudentController;
import com.prakash.controller.UserController;
import com.prakash.entity.Student;
import com.prakash.entity.User;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("----------------Welcome in IB ONLINE EXAMINATION SYSTEM------------------");

        while (true)
        {


            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            System.out.println("Enter your Requirement : ");
            int choice  = Integer.parseInt(sc.nextLine());

            switch (choice)
            {

                case  1-> {
                    System.out.println("Enter Credentials :");
                    User user = new User();

                    System.out.println("Enter Email : ");
                    user.setEmail(sc.nextLine());
                    System.out.println("Enter Password : ");
                    user.setPassword(sc.nextLine());

                    //user decide
                    String role = new UserController().verifyUser(user);
                    if (role.equalsIgnoreCase("STUDENT")) {

                        Student student = new StudentController().getStudent(user.getEmail(), user.getPassword());
                        new StudentMain(student);
                    }
                    else if (role.equalsIgnoreCase("ADMIN"))
                    {
                        new AdminMain(user);
                    }
                    else if(role.equalsIgnoreCase("UNAUTHORIZED STUDENT :("))
                    {
                        System.out.println("UNAUTHORIZED STUDENT :(");
                    }
                    else
                    {
                        System.out.println("Please register first");
                    }

                }


                case 2 -> {
                    System.out.println("Enter your name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter email : ");
                    String  email = sc.nextLine();
                    System.out.println("Enter password : ");
                    String password = sc.nextLine();
                    System.out.println("Enter Role (STUDENT or ADMIN)");
                    String role = sc.nextLine();

                    new UserController().saveUser(new User(name,email,password,role));

                }
                case 3 -> System.exit(0);


                default -> System.out.println("Enter valid choice : ");
            }
        }



    }
}