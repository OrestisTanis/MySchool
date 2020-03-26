/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.creators.list;

import bootcamp.core.Course;
import bootcamp.core.Student;
import bootcamp.core.Assignment;
import bootcamp.lists.CourseStudents;
import bootcamp.lists.CourseAssignments;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.Input;

/**
 *
 * @author orestis
 */
public class CourseAssignmentsCreator {
//    private List<Course> listOfAvailableCourses;
//    private List<Assignment> listOfAvailableAssignments;
//    private List<CourseAssignments> listOfCourseAssignments;
    
    /* Constructor */
//    public CourseAssignmentsCreator(List<Course> listOfCourses, List<Assignment> assignments) {
//        this.listOfAvailableCourses = listOfCourses;
//        this.listOfAvailableAssignments = assignments;
//    }
    
    public CourseAssignmentsCreator(){
        
    }
    /* Getter */
//    public List<CourseAssignments> getListOfCourseAssignments(){
//        if (listOfCourseAssignments == null){
//            listOfCourseAssignments = new ArrayList();
//        }
//        return listOfCourseAssignments;
//    }
    
    public boolean availableAssignmentsToInsert(List<Assignment> listOfAvailableAssignments){
        if (listOfAvailableAssignments.isEmpty()){
                System.out.println("No available assignments to insert. Returning to main menu.");
                //choice = "N";
                return false;
        }
        return true;
    }
    
    private Assignment getAssignmentFromUser(List<Assignment> listOfAvailableAssignments){
        System.out.println("\nChoose an assignment to insert to a course: ");
        Input.printOptions(listOfAvailableAssignments);
        int choiceNum = Input.getOptionInt(listOfAvailableAssignments);
        // Save trainer selected by the user
        Assignment assignment = listOfAvailableAssignments.get(choiceNum - 1);
        return assignment;
    }
    
    private Course getCourseFromUser(Assignment assignment, List<Course> listOfAvailableCourses){
        System.out.printf("\nChoose a course to insert the assignment %s to:\n", assignment.getTitle());
        Input.printOptions(listOfAvailableCourses);
        int choiceNum = Input.getOptionInt(listOfAvailableCourses);
        Course course = listOfAvailableCourses.get(choiceNum - 1);
        return course;
    }
    
    public List<CourseAssignments> run(List<Course> listOfAvailableCourses, List<Assignment> listOfAvailableAssignments, List<CourseAssignments> listOfAssignmentsPerCourse){
        Assignment assignment;
        Course course;
        int choiceNum;
        String choice = "Y";
        //List<Course> listOfAvailableCourses;
        //List<Assignment> listOfAvailableAssignments;
        //List<CourseAssignments> listOfCourseAssignments;
        //CourseAssignments courseAssignments = null;
        
        while(choice.equalsIgnoreCase("Y")){
            if (listOfAvailableAssignments.isEmpty()){
                System.out.println("No available assignments to insert. Returning to main menu.");
                return listOfAssignmentsPerCourse;
            }
            
            if (listOfAvailableCourses.isEmpty()){
              System.out.println("No available courses to insert assignments to. Returning to main menu.");
              return listOfAssignmentsPerCourse;
            }
                       
//            System.out.println("\nChoose an assignment to insert to a course: ");
//            Input.printOptions(listOfAvailableAssignments);
//            choiceNum = Input.getOptionInt(listOfAvailableAssignments);
//            // Save trainer selected by the user
//            assignment = listOfAvailableAssignments.get(choiceNum - 1);
              assignment = getAssignmentFromUser(listOfAvailableAssignments);
           
//            System.out.printf("\nChoose a course to insert the assignment %s to:\n", assignment.getTitle());
//            Input.printOptions(listOfAvailableCourses);
//            choiceNum = Input.getOptionInt(listOfAvailableCourses);
//            course = listOfAvailableCourses.get(choiceNum - 1);
              course = getCourseFromUser(assignment, listOfAvailableCourses);
              
//            if (listOfCourseAssignments == null){
//                listOfCourseAssignments = new ArrayList();
//            }  
            boolean dateValid = true;
            if (course.getStartDate().isAfter(assignment.getSubDateTime()) || course.getEndDate().isBefore(assignment.getSubDateTime())){
                System.out.printf("Assignment %s with submission date %s is not between course start date %s and course end date %s%n", assignment.getTitle(), assignment.getSubDateTime().toString(), course.getStartDate(), course.getEndDate());
                dateValid = false;
                //System.out.println("******* INVALID DATE");
            }
            
            boolean assignmentAlreadyAdded = assignmentIsAlreadyInList(assignment, listOfAssignmentsPerCourse);
            //boolean dateIsValid = !choice.equals("invalidDate");
            if (assignmentAlreadyAdded && dateValid) {
                System.out.printf("Assignment %s with submission date %s and total mark %s already assigned to course %s/%s/%s!%n", assignment.getTitle(), assignment.getSubDateTime().toString(), assignment.getTotalMark(), course.getTitle(), course.getStream(), course.getType());
            }
            else if (dateValid && listOfAssignmentsPerCourse.isEmpty()){
                    CourseAssignments assignmentsPerCourse = addAssignmentToNewCourse(course, assignment);
                    addToCourseAssignmentsList(assignmentsPerCourse, listOfAssignmentsPerCourse);
                    System.out.printf("Assignment %s successfully added to course %s/%s/%s!%n", assignment.getTitle(), course.getTitle(), course.getStream(), course.getType());
            }
            else if (dateValid){
                int courseIndexInList = getCourseAssignmentsIndexInList(listOfAssignmentsPerCourse, course);
                if (courseIndexInList > -1){
                    listOfAssignmentsPerCourse.get(courseIndexInList).addToLisT(assignment);
                }
                else{
                    CourseAssignments assignmentsPerCourse = addAssignmentToNewCourse(course, assignment);
                    addToCourseAssignmentsList(assignmentsPerCourse, listOfAssignmentsPerCourse);
                }
                System.out.printf("Assignment %s successfully added to course %s/%s/%s!%n", assignment.getTitle(), course.getTitle(), course.getStream(), course.getType());                                
            }
            System.out.println("\nDo you want to insert another Assignment to a course? (Y/N)");
            choice = Input.getString("[yYnN]", "Y/N?");
        }
        return listOfAssignmentsPerCourse;
    }
    
    private void addToCourseAssignmentsList(CourseAssignments courseAssignments, List<CourseAssignments> listOfCourseAssignments){
        // Lazy-instantiate the list
        if (listOfCourseAssignments == null){
            listOfCourseAssignments = new ArrayList();
        }
        listOfCourseAssignments.add(courseAssignments);
    }
    
    /* Returns the index of the CourseTrainer object which has the specified course,
       or returns -1 if it is not found */
    private int getCourseAssignmentsIndexInList(List<CourseAssignments> courseAssignmentsList, Course course){
        for (int i = 0; i < courseAssignmentsList.size(); i++){
            /* If there is already a courseTrainers object in the list with the 
               specified course, just addToLisT trainers */
            if (courseAssignmentsList.get(i).getCourse().equals(course)){
                //listOfCourseTrainers.get(i).addToLisT(trainer);
                return i;
            }
        }
        return -1;
    }
    
    private boolean assignmentIsAlreadyInList(Assignment assignment, List<CourseAssignments> listOfCourseAssignments){
        for (CourseAssignments assignmentsPerCourse : listOfCourseAssignments){
            if (assignmentsPerCourse.getList().contains(assignment)){
                //choice = "N";
                return true;
            }
        }
        return false;
    }
    
    private CourseAssignments addAssignmentToNewCourse(Course course, Assignment assignment){
        CourseAssignments assignmentsPerCourse = new CourseAssignments(course);
        assignmentsPerCourse.addToLisT(assignment);
        return assignmentsPerCourse;
    }
}
