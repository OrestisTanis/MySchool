/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.creators;

import bootcamp.core.Course;
import bootcamp.core.Student;
import bootcamp.core.Trainer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.Input;

/**
 *
 * @author orestis
 */
public class StudentCreator extends Creator {
    /* Fields */
   // private static List<Student> listOfStudents;
    
    /* Constructor */
    public StudentCreator() {
        
    }

    /* Properties */
//    public List<Student> getStudents() {
//        return listOfStudents;
//    }

    /* Methods */
     public List<Student> createStudents(List<Student> listOfStudents) {
        String choice = "Y";
        while (choice.equalsIgnoreCase("Y")) {
            String firstName = getFirstNameFromUser(nameRegex, nameInvalidMsg);
            String lastName = getLastNameFromUser(nameRegex, nameInvalidMsg);
            LocalDate birthDate = getBirthDateFromUser(LocalDate.parse("01/01/1950", formatter), LocalDate.now().minusYears(18));
            Double tuitionFees = getFeesFromUser();              
            Student student = new Student(firstName, lastName, birthDate, tuitionFees);
            addStudentToList(student, listOfStudents);
            System.out.println("\nDo you want to create another Student? (Y/N)");
            choice = Input.getString("[yYnN]", "Y/N?");
        }
        return listOfStudents;
    }
    private String getFirstNameFromUser(String nameRegex, String nameInvalidMsg){
        System.out.println("\nPlease enter student first name:");
        return Input.getString(nameRegex, nameInvalidMsg);
    }
    private String getLastNameFromUser(String nameRegex, String nameInvalidMsg){
        System.out.println("\nPlease enter student last name:");
        return Input.getString(nameRegex, nameInvalidMsg);
    }
    private LocalDate getBirthDateFromUser(LocalDate minDate, LocalDate maxDate){
        String minDateStr = minDate.format(formatter);
        String maxDateStr = maxDate.format(formatter);
        String invalidDateMsg = getInvalidDateBetweenMsg(minDateStr, maxDateStr);
        System.out.printf("\nPlease enter student date of birth (%s): \n", dateFormatStr);
        return Input.getLocalDateFromTo(minDate, maxDate, dateFormatStr, invalidDateMsg);
    }
    private Double getFeesFromUser(){
        System.out.println("\nPlease enter student tuition fees: ");
        double result = Input.getPositiveDouble();  
        return result;
    }
    private void addStudentToList(Student student,List<Student> listOfStudents){
        boolean studentAlreadyCreated = studentExistsInList(student, listOfStudents);
        if (studentAlreadyCreated){
            System.out.printf("Student %s %s with birth date %s already exists!%n", student.getFirstName(), student.getLastName(), student.getDateOfBirth());
        }
        else {
            listOfStudents.add(student);
            System.out.printf("\nStudent %s %s successfuly created!", student.getFirstName(), student.getLastName());
        }            
    }
    private boolean studentExistsInList(Student student, List<Student> listOfStudents){
        boolean result = false;
        for (Student item: listOfStudents){
            if (item.equals(student)){
                result = true;
            }
        }
        return result;
    }
   
}
