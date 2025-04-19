package com.prakash;

import com.prakash.controller.QuestionController;
import com.prakash.controller.StudentController;
import com.prakash.entity.Question;
import com.prakash.entity.Student;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class StudentMain {

    Scanner sc = new Scanner(System.in);

    int gkMarks;
    int englishMarks;
    int mathsMarks;
    int aptitudeMarks;
    int reasoningMarks;
    int totalMarks;

    public StudentMain(Student student) {
        System.out.println("-----------------Welcome "+student.getName()+"-------------------------\n");

        String examInstructions = """
    <html>
    <body style='font-family: Arial, sans-serif; font-size: 12px;'>
        <br><br><br>
        <h1 style='color:red;'>📌 Exam Instructions</h1>
        <ul>
            <li><b>🔹 Exam Start -> </b> Click on any subject to begin.</li>
            <li><b>🔹 Question Display: </b> All questions of the selected subject will appear.</li>
            <li><b>🔹 Switching Subjects: </b> You can switch between subjects anytime.</li>
            <li><b>🔹 Answering Questions: </b> Click on one option per question, it is auto-saved.</li>
            <li><b>🔹 Timer: </b> The exam duration is <b>1 hour</b>. It starts when you select your first subject.</li>
            <li><b>🔹 Auto-Submission: </b> The exam will submit automatically when the time ends.</li>
            <li><b>🔹 Manual Submission: </b> If you finish early, click the <b>'Submit Exam'</b> button.</li>
        </ul>

        <br><h2>📜 General Exam Rules</h2>
        <ul>
            <li><b>✅ Read all questions carefully before answering.</b></li>
            <li><b>✅ Do not refresh or close the window during the exam.</b></li>
            <li><b>✅ Any attempt to cheat may result in disqualification.</b></li>
        </ul>

        <br><br>
        <h2>⚠ Important Notes:</h2>
        <p style='color:red;'><b>❌ Do not close the window! The exam will be auto-submitted after 1 hour.</b></p>
        <p>For any technical issues, contact the exam administrator.</p>

        <br><br><br>
        <h1 style='color:green;'>BEST OF LUCK</h1>
    </body>
    </html>
    """;


        System.out.println("Enter 1 for start exam ");

        //Time Functionality
        LocalTime currTime = LocalTime.now();

if(Integer.parseInt(sc.nextLine()) != 1) {
    System.out.println("Please enter 1 for start the exam");
}
else {
        int i = 2;
        while (i != 0)
        {

            System.out.println("When you see questions you only need to enter the correct option number please enter b/q 1 to 4: ");
            System.out.println("Choose a subject : \n1.GK \n2.Maths \n3.English \n4.Aptitude \n5.Reasoning ");

            String subject = switch (Integer.parseInt(sc.nextLine()))
            {
                case 1 -> "GK";
                case 2 -> "Maths";
                case 3 -> "English";
                case 4 -> "Aptitude";
                case 5 -> "Reasoning";
                default -> "";
            };

            if(subject != "") i--;

            List<Question> questions = new QuestionController().getAllQuestionsBySection(subject);

            switch (subject){
                case "GK"->{
                    for (Question q : questions){
                        System.out.println(q.getQuestion());
                        System.out.println("1. "+q.getOption_A());
                        System.out.println("2. "+q.getOption_B());
                        System.out.println("3. "+q.getOption_C());
                        System.out.println("4. "+q.getOption_D());
                        int option = Integer.parseInt(sc.nextLine());

                        if (option <= 0 || option >= 5)
                        {
                            System.out.println("Please choose option b/w 1 to 4");
                        }
                        else {
                            String choosedoption =  switch (option)
                            {
                                case 1 -> q.getOption_A();
                                case 2 -> q.getOption_B();
                                case 3 -> q.getOption_C();
                                case 4 -> q.getOption_D();
                                default -> "";
                            };

                            if (choosedoption.equalsIgnoreCase(q.getCorrect_answer()))
                                gkMarks++;

                        }


                    }
                }
                case "Maths"->{
                    for (Question q : questions){
                        System.out.println(q.getQuestion());
                        System.out.println("1. "+q.getOption_A());
                        System.out.println("2. "+q.getOption_B());
                        System.out.println("3. "+q.getOption_C());
                        System.out.println("4. "+q.getOption_D());
                        int option = Integer.parseInt(sc.nextLine());

                        if (option <= 0 || option >= 5)
                        {
                            System.out.println("Please choose option b/w 1 to 4");
                        }
                        else {
                            String choosedoption =  switch (option)
                            {
                                case 1 -> q.getOption_A();
                                case 2 -> q.getOption_B();
                                case 3 -> q.getOption_C();
                                case 4 -> q.getOption_D();
                                default -> "";
                            };

                            if (choosedoption.equalsIgnoreCase(q.getCorrect_answer()))
                                mathsMarks++;
                        }
                    }

                }
                case "English"->{
                    for (Question q : questions){
                        System.out.println(q.getQuestion());
                        System.out.println("1. "+q.getOption_A());
                        System.out.println("2. "+q.getOption_B());
                        System.out.println("3. "+q.getOption_C());
                        System.out.println("4. "+q.getOption_D());
                        int option = Integer.parseInt(sc.nextLine());

                        if (option <= 0 || option >= 5)
                        {
                            System.out.println("Please choose option b/w 1 to 4");
                        }
                        else {
                            String choosedoption =  switch (option)
                            {
                                case 1 -> q.getOption_A();
                                case 2 -> q.getOption_B();
                                case 3 -> q.getOption_C();
                                case 4 -> q.getOption_D();
                                default -> "";
                            };

                            if (choosedoption.equalsIgnoreCase(q.getCorrect_answer()))
                                englishMarks++;
                        }

                    }

                }
                case "Aptitude"->{
                    for (Question q : questions){
                        System.out.println(q.getQuestion());
                        System.out.println("1. "+q.getOption_A());
                        System.out.println("2. "+q.getOption_B());
                        System.out.println("3. "+q.getOption_C());
                        System.out.println("4. "+q.getOption_D());
                        int option = Integer.parseInt(sc.nextLine());

                        if (option <= 0 || option >= 5)
                        {
                            System.out.println("Please choose option b/w 1 to 4");
                        }
                        else {
                            String choosedoption =  switch (option)
                            {
                                case 1 -> q.getOption_A();
                                case 2 -> q.getOption_B();
                                case 3 -> q.getOption_C();
                                case 4 -> q.getOption_D();
                                default -> "";
                            };

                            if (choosedoption.equalsIgnoreCase(q.getCorrect_answer()))
                                aptitudeMarks++;
                        }
                    }

                }
                case "Reasoning"->{
                    for (Question q : questions){
                        System.out.println(q.getQuestion());
                        System.out.println("1. "+q.getOption_A());
                        System.out.println("2. "+q.getOption_B());
                        System.out.println("3. "+q.getOption_C());
                        System.out.println("4. "+q.getOption_D());
                        int option = Integer.parseInt(sc.nextLine());

                        if (option <= 0 || option >= 5)
                        {
                            System.out.println("Please choose option b/w 1 to 4");
                        }
                        else {
                            String choosedoption =  switch (option)
                            {
                                case 1 -> q.getOption_A();
                                case 2 -> q.getOption_B();
                                case 3 -> q.getOption_C();
                                case 4 -> q.getOption_D();
                                default -> "";
                            };

                            if (choosedoption.equalsIgnoreCase(q.getCorrect_answer()))
                                reasoningMarks++;
                        }
                    }
                }
                case ""-> System.out.println("Invalid subject is choose");
            }

            System.out.println(subject+" Is completed wait for next");


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
     totalMarks = gkMarks+mathsMarks+englishMarks+aptitudeMarks+reasoningMarks;
    student.setResult(totalMarks);
    new StudentController().updateResult(student);
}


        System.out.println("\n-------------"+student.getName()+"  Result------------");
        System.out.println("GK marks             "+gkMarks);
        System.out.println("English marks        "+englishMarks);
        System.out.println("Maths marks          "+mathsMarks);
        System.out.println("Aptitude marks       "+aptitudeMarks);
        System.out.println("Reasoning marks      "+reasoningMarks);

        String finalResult = totalMarks >= Student.examCutoff  ? "PASS" : "FAIL";
        System.out.println("\nTotal Marks "+totalMarks+" "+finalResult);

        System.out.println("Enter 1 for exit");
        if(Integer.parseInt(sc.nextLine()) == 1)
            System.exit(0);


    }
}
