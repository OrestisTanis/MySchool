/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.creators.list;

import bootcamp.core.Course;
import bootcamp.core.Student;
import bootcamp.core.Trainer;
import bootcamp.lists.CourseStudents;
import bootcamp.lists.CourseTrainers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.Input;

/**
 *
 * @author orestis
 */
public class CourseStudentsCreator {
//    private List<Course> listOfAvailableCourses;
//    private List<Student> listOfAvailableStudents;
//    private static List<CourseStudents> listOfCourseStudents;
    
    /* Constructor */
//    public CourseStudentsCreator(List<Course> listOfCourses, List<Student> students) {
//        this.listOfAvailableCourses = listOfCourses;
//        this.listOfAvailableStudents = students;
//    }
//    
    public CourseStudentsCreator(){
        
    }
    
    /* Getter */
//    public List<CourseStudents> getListOfCourseStudents(){
//        if (listOfCourseStudents == null){
//            listOfCourseStudents = new ArrayList();
//        }
//        return listOfCourseStudents;
//    }
    
    public List<CourseStudents> run(List<Course> listOfAvailableCourses, List<Student> listOfAvailableStudents, List<CourseStudents> listOfStudentsPerCourse){
        Student student;
        Course course;
        int choiceNum;
        String choice = "Y";
        //CourseStudents courseStudents = null;
        
        while(choice.equalsIgnoreCase("Y")){
            // No trainers available to assign
            if (listOfAvailableStudents.isEmpty()){
                System.out.println("No available students to assign. Returning to main menu.");
                //choice = "N";
                return listOfStudentsPerCourse;
            }
            
            // No courses available to assign trainers to
            if (listOfAvailableCourses.isEmpty()){
              System.out.println("No available course to assign students to. Returning to main menu.");
              //choice = "N";
              return listOfStudentsPerCourse;
            }
                       
            System.out.println("\nChoose a trainer to assign to a course: ");
            Input.printOptions(listOfAvailableStudents);
            choiceNum = Input.getOptionInt(listOfAvailableStudents);
            // Save trainer selected by the user
            student = listOfAvailableStudents.get(choiceNum - 1);
           
            System.out.printf("\nChoose a course to assign trainer %s to:\n", student);
            Input.printOptions(listOfAvailableCourses);
            choiceNum = Input.getOptionInt(listOfAvailableCourses);
            course = listOfAvailableCourses.get(choiceNum - 1);
            
            boolean studentAlreadyAdded = studentIsAlreadyInList(student, listOfStudentsPerCourse);
            if (studentAlreadyAdded) {
                System.out.printf("Student %s %s with birth date %s is already assigned to course %s/%s/%s!%n", student.getFirstName(), student.getLastName(), student.getDateOfBirth(), course.getTitle(), course.getStream(), course.getType());
            }
            else if (listOfStudentsPerCourse.isEmpty()){
                    CourseStudents studentsPerCourse = addStudentToNewCourse(course, student);
                    listOfStudentsPerCourse.add(studentsPerCourse);
                    System.out.printf("Student %s %s successfully added to course %s/%s/%s!%n", student.getFirstName(), student.getLastName(), course.getTitle(), course.getStream(), course.getType());            }
            else {
                int courseIndexInList = getCourseStudentsIndexInList(course, listOfStudentsPerCourse);
                if (courseIndexInList > -1){
                    listOfStudentsPerCourse.get(courseIndexInList).addToLisT(student);
                }
                else{
                    CourseStudents studentsPerCourse = addStudentToNewCourse(course, student);
                    listOfStudentsPerCourse.add(studentsPerCourse);
                }
                System.out.printf("Student %s %s successfully added to course %s/%s/%s!%n", student.getFirstName(), student.getLastName(), course.getTitle(), course.getStream(), course.getType());
                
            }
            System.out.println("\nDo you want to insert another Student to a course? (Y/N)");
            choice = Input.getString("[yYnN]", "Y/N?");
        }
        return listOfStudentsPerCourse;
    }
    
//    private void addToCourseStudentsList(CourseStudents courseStudents, List<CourseStudents> listOfStudentsPerCourse){        
//        listOfStudentsPerCourse.add(courseStudents);
//    }
    
    /* Returns the index of the CourseStudents object which has the specified course,
       or returns -1 if it is not found */
    private int getCourseStudentsIndexInList(Course course, List<CourseStudents> listOfStudentsPerCourse){
        for (int i = 0; i < listOfStudentsPerCourse.size(); i++){
            if (listOfStudentsPerCourse.get(i).getCourse().equals(course)){
                //listOfCourseTrainers.get(i).addToLisT(trainer);
                return i;
            }
        }
        return -1;
    }
    
    private boolean studentIsAlreadyInList(Student student, List<CourseStudents> listOfStudentsPerCourse){
        for (CourseStudents items : listOfStudentsPerCourse){
            if (items.getList().contains(student)){
                //choice = "N";
                return true;
            }
        }
        return false;
    }
    
    private CourseStudents addStudentToNewCourse(Course course, Student student){
        CourseStudents studentsPerCourse = new CourseStudents(course);
        studentsPerCourse.addToLisT(student);
        return studentsPerCourse;
    }
}
