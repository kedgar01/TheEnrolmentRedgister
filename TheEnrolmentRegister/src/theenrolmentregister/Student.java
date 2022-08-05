/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theenrolmentregister;

//Here are the imports
//import java.io.BufferedWriter;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author B00812794
 */
public class Student extends TheEnrolmentRegister{
    /*Using extends allows a class - inherit attributes and methods from one class to another*/
    //Scanner scan reads user input
    private final Scanner scan = new Scanner(System.in);
    //private int maxStudents = 20; This was going to be used to only allow 20 students to be added to file

    
    public void Populate() throws FileNotFoundException, IOException{
        //throws FileNotFoundException and IOException helps to handle exceptions
        Scanner findStudent = new Scanner(studentDetails);
        //scans the txt file StudentsDetails
        while (findStudent.hasNextLine()) {
            //scans while file has nectline
            String data = findStudent.nextLine();
            //saves each line to a String called data
            studentsEnrolled.add(data);
            //adds data(each student)to arraylist
        }
    }
    
    public void SearchStudent() throws FileNotFoundException{
        Scanner findStudent = new Scanner(studentDetails);
        System.out.print("Enter name to search for: ");
        String searchName = scan.nextLine();
        //prompts user to enter name to search for and user scanner to read it and comapre
        System.out.println("Here are your results:");
        while (findStudent.hasNextLine()) {
            String data = findStudent.nextLine();
            if(data.contains(searchName)){
                System.out.println(data);
                //prints out studnet name if its conatined in file
            }
        }
    }
    
    /*public void DeleteStudent() throws FileNotFoundException, IOException{
        Scanner findStudent;
        String tempfile = "temp.txt";
        File oldFile = new File("StudentDetails.txt");
        File newFile = new File(tempfile);
        String name = "";
        String dob = "";
        String address = "";
        String gender = "";
        FileWriter fw = new FileWriter(tempfile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        findStudent = new Scanner(new File("StudentDetails.txt"));
        findStudent.useDelimiter("[--/n]");
        System.out.println("Enter student name you wish to delete");
        String Sname = scan.nextLine();
        while(findStudent.hasNext()){
            String data = findStudent.nextLine();
            if(data.equals(Sname)){
                pw.println(name + "-- " + dob + "-- " + address + "-- " + gender);
            }
        }
        findStudent.close();
        pw.flush();
        pw.close();
        oldFile.delete();
        File dump = new File("StudentDetails.txt");
        newFile.renameTo(dump);
    }*/
    
    public void DelStudent() throws FileNotFoundException{            
        Scanner findStudent = new Scanner(studentDetails);
        System.out.print("Enter name to search for: ");
        //prompts user to enter name to search for to delete
        String searchName = scan.nextLine();
        while (findStudent.hasNextLine()) {
            String data = findStudent.nextLine();
            //saves each students details as a string 'data'
            if(data.contains(searchName)){
                System.out.println(data);
                studentsEnrolled.remove(data);
                //if the string contains the searched name then remove it
                System.out.println("Removed");
                //print statement to allow user to knwo its been deleted
            }
        }
        for (String stud:studentsEnrolled){
            System.out.println(stud);
            //prints out the students details
        } //This code shows that this method does remove the student when it prints out eah student but doesn't
        //add it to the main Arraylist (couldnt get that working)
}


    public void AddStud() throws IOException{
        if(numOfStudents <=20){//heres evidence of trying to impliment only allowing 20 studbents to be added
            while(true){
            //while loop to keep method running until all details are entered
            System.out.println("Full name:");
            String newName = scan.nextLine();
            studentsEnrolled.add(newName);
            //prompts user to add student detaail, scans it and saves detail as a string
            studentsEnrolled.add("-- ");
            System.out.println("DOB (DD/MM/YY):");
            String newDob = scan.nextLine();
            studentsEnrolled.add(newDob);
            //prompts user to add student detaail, scans it and saves detail as a string
            studentsEnrolled.add("-- ");
            System.out.println("Address:");
            String newAddress = scan.nextLine();
            studentsEnrolled.add(newAddress);
            //prompts user to add student detaail, scans it and saves detail as a string
            studentsEnrolled.add("-- ");
            System.out.println("Gender (M/F):");
            String newGender = scan.nextLine();
            //prompts user to add student detaail, scans it and saves detail as a string
            while(true){
                if("F".equals(newGender) || "M".equals(newGender)){
                    studentsEnrolled.add(newGender);
                    break;
                }
                else if(!"F".equals(newGender) || !"M".equals(newGender)){
                    System.out.println("Incorrect input try again");
                    System.out.println("Gender (M/F):");
                    newGender = scan.nextLine();
                }
                //while statement to ensure user enters either 'M' or 'F' for gender
            }
            numOfStudents++; //adds student to help with the max 20 students allocation
            System.out.print("Student added is: ");
            for ( String stud : studentsEnrolled)
                System.out.print(stud + " ");
            //prints out students details that has been entered with a space
            File StudDetails = new File("StudentDetails.txt");
            PrintWriter writer = new PrintWriter(new FileWriter(StudDetails, true)); 
            for(String str: studentsEnrolled) {
                writer.write(str + " ");
                }
            writer.write("\n");
            writer.close();
            //writes the new students details to StudentsDetials.txt file and closes writer
            break;
    }
    }
    }

    public void Report() throws FileNotFoundException, IOException {
        File CourseDetails = new File("CourseDetails.txt");
        //imports instance of file CourseDetails.txt
        PrintWriter writer = new PrintWriter(CourseDetails);
        //instances printwriter to be used in writing data to file
        String lecturer = "Alan Thyme";// creating variable of lecturer
        String course = "Computer Science"; // creating variable of course
        float males = 0; // creating varible males of type float for calulations
        float females = 0; // creating varible females of type float for calulations
        Scanner findStudent = new Scanner(studentDetails);
        while (findStudent.hasNextLine()) {
            //finding student while file has nextline
            String data = findStudent.nextLine();
            studentsEnrolled.add(data);
            //creating a string of the next line as data and adding it to the arraylist
            if (data.contains("M")){
                males++;
                //if data contains 'M' increase males count by 1
            }
            else if(data.contains("F")){
                females++;
                //if data contains 'F' increase females count by 1
        }
        }
        float totalStudents = males  + females; //adding males and females counts together to get total students counts
        float malePercentage = (float)((males/totalStudents)*100); //calculating male percentage
        float femalePercentage = (float)((females/totalStudents)*100); //calculating female percentage
        System.out.println("Report: Here are the course details:");
        System.out.println();
        System.out.println("The lecturer is: " + lecturer); //printing the lecturer by variable
        System.out.println("The Course is: " + course);//printing the course by varible
        System.out.println("There are " + totalStudents + " Students Enrolled"); //printing the total students by variable
        System.out.println("There are " + males + " male students on this course"); //printing the total males by variable
        System.out.println("There are " + females + " female students on this course");//printing the total females by variable
        System.out.print("Percentage of males = ");
        System.out.printf("%.2f", malePercentage);//printing the percentage of male students by variable
        System.out.println();
        System.out.print("Percentage of females = ");
        System.out.printf("%.2f", femalePercentage); //printing the percentage of female students by variable
        System.out.println();
        writer.write("Lecturer is: " + lecturer);//writing the lecturer by variable to file
        writer.write("\n"); //write a skip line to file
        writer.write("Course is: " + course);//writing the course by variable to file
        writer.write("\n");//write a skip line to file
        writer.write("Total number of students enrolled is: " + totalStudents);//writing the total students by variable to file
        writer.write("\n");//write a skip line to file
        writer.write("Percentage of males is: " + malePercentage); //writing the percentage of male students by variable to file
        writer.write("\n");//write a skip line to file
        writer.write("Percentage of females is: " + femalePercentage);  //writing the percentage of female students by variable to file
        writer.write("\n");//write a skip line to file
        writer.close(); // close writer to file
    }
    
}
