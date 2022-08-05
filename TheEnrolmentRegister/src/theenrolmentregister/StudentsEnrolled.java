/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theenrolmentregister;

//Here are the imports
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author B00812794
 */
public class StudentsEnrolled extends TheEnrolmentRegister{
      
    public void read(){
      
      try {
          try (Scanner myReader = new Scanner(studentDetails)){
          //scans the txt file StudentsDetails
              System.out.println();
              System.out.println("Here are the enrolled Students: ");
              //print statement to tell users the following data are the students enrolled
              while (myReader.hasNextLine()) {
                  //scans while file has nectline
                  String data = myReader.nextLine();
                  //saves each line to a String called data
                  System.out.println(data);
                  //print statement prints each line of file (student) to screen
              }   }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      //prints a statement that an error occured if file not found exception occurs
    }
      /*using a try catch statement help prevent errors by catching 
      exceptions*/
      }
   
    }