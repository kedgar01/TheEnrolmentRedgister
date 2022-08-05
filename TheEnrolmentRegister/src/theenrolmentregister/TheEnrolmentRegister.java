package theenrolmentregister;

//Here are the imports
//import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author B00812794
 */
public class TheEnrolmentRegister {
    ArrayList<String> studentsEnrolled = new ArrayList<>(); // creating arraylist to store students details while program is running
    int numOfStudents = 0; //instatising varible for number of students of 0
    File studentDetails = new File("StudentDetails.txt");
    
    public static void main(String[] args) throws IOException {
        //main static void begins here
        System.out.println(System.getProperty("user.dir")) ;
        //ArrayList<TheEnrolmentRegister> students;
        System.out.println("Please choose one of the following:");
        System.out.println("1: See Enrolled Students");
        System.out.println("2: Add Student");
        System.out.println("3: Search for Student");
        System.out.println("4: Delete a Student");
        System.out.println("5: Report of Course");
        System.out.println("6 - exit");
        //system prints above the main features of the menu and the corresponding number related to call methods
        Scanner menuScan = new Scanner(System.in);
        System.out.println();

        while(true){
        //while loop to keep repeating until user terminates program by menu feature.
            System.out.print("Enter option number:");
            int choice = menuScan.nextInt();//making user input a variable of int called choice
            Student st = new Student(); //creating an instance of the class
            StudentsEnrolled se = new StudentsEnrolled();//creating an instance of the class

            switch(choice){
                case 1:
                   st.Populate();//calling method from student class
                   se.read();//calling method from students enrolled class
                   System.out.println();
                   break;
                case 2:
                   st.AddStud();//calling method from student class
                   System.out.println();
                   break;
                case 3:
                   st.SearchStudent();//calling method from student class
                   System.out.println();
                   break;
                case 4:
                   st.DelStudent();//calling method from student class
                   break;
                case 5:
                   st.Report();//calling method from student class
                   break;
                case 6:
                   System.out.println("Thank you, Goodbye!");
                   System.exit(0);
                   break;
                default:
                    try{
                        System.out.println("Invalid option. Please try again!");
                        System.out.println();}
                    catch (InputMismatchException exception){
                        System.out.println("Invalid option. Please try again!");
                        System.out.println();
                        }
                /*using a sitch case to make use of a menu,
                    each case number corelates to menu feature which calls the 
                    methods related o the menu feature*/
              }
        }
}
}