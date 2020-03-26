/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.creators;

import bootcamp.core.Assignment;
import bootcamp.core.Course;
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
public class AssignmentCreator extends Creator {
    /* Fields */
//    private static List<Assignment> listOfAssignments;
//    private String title;
//    private String description;
//    private int totalMark;
//    private LocalDate subDate;
    
    /* Constructor */
    public AssignmentCreator(){
    }
    
    /* Getters */
//    public List<Assignment> getAssignments(){
//        return listOfAssignments;
//    }
    
    /* Methods */
    public List<Assignment> createAssignments(List<Assignment> listOfAssignments){
        String choice = "Y";
        while(choice.equalsIgnoreCase("Y")){
            String title = getTitleFromUser(titleRegex, titleInvalidMsg);
            String description = getDescriptionFromUser(titleRegex, titleInvalidMsg);
            LocalDate subDate = getSubDateFromUser(LocalDate.parse("01/01/2015", formatter));
            int totalMark = getTotalMarkFromUser();
            Assignment assignment = new Assignment(title, description, subDate, totalMark);
            addAssignmentToList(assignment, listOfAssignments);
            System.out.println("\nDo you want to create another assignment? (Y/N)");
            choice = Input.getString("[yYnN]", "Y/N?");
        }
        return listOfAssignments;
    }
    private String getTitleFromUser(String titleRegex, String titleInvalidMsg){
        System.out.println("\nPlease enter assignment title:");
        return Input.getString(titleRegex, titleInvalidMsg);
    }
    private String getDescriptionFromUser(String titleRegex, String titleInvalidMsg){
        System.out.println("\nPlease enter assignment description: ");
        return Input.getString(titleRegex, titleInvalidMsg);
    }
    private LocalDate getSubDateFromUser(LocalDate minDate){
        System.out.printf("\nPlease enter assignment submission date (%s): \n", dateFormatStr);
        //LocalDate minDate = ;
        String dateInvalidMsg = getInvalidDateAfterMsg(minDate);
        return Input.getLocalDateAfter(minDate, dateFormatStr, dateInvalidMsg);
    }
    private int getTotalMarkFromUser(){
        System.out.println("\nPlease enter assignment total mark needed for a student to pass: ");
        return Input.getIntFromTo(1, 100);
    }
    private void addAssignmentToList(Assignment assignment, List<Assignment> listOfAssignments){
        boolean assignmentAlreadyCreated = assignmentExistsInList(assignment, listOfAssignments);
        if (assignmentAlreadyCreated){
            System.out.printf("Assignment %s with submission date %s  and total mark %s already exists!%n", assignment.getTitle(), assignment.getSubDateTime().toString(), assignment.getTotalMark());
        }
        else {
            listOfAssignments.add(assignment);
            System.out.printf("\nAssignment \"%s\" successfuly created!", assignment.getTitle());
        }
    }
    private boolean assignmentExistsInList(Assignment assignment, List<Assignment> listOfAssignments){
        boolean result = false;
        for (Assignment item: listOfAssignments){
            if (item.equals(assignment)){
                result = true;
            }
        }
        return result;
    }
}
