/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bootcamp.core.Assignment;
import bootcamp.core.Course;
import bootcamp.core.Student;
import bootcamp.core.Trainer;
import bootcamp.lists.CourseAssignments;
import bootcamp.lists.CourseStudents;
import bootcamp.lists.CourseTrainers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static main.MainClass.listOfCourseTrainers;

/**
 *
 * @author orestis
 */
public class SyntheticData {
    private List<Course> courses;
    private List<Trainer> trainers;
    private List<Assignment> assignments;
    private List<Student> students;
    private List<CourseStudents> listOfCourseStudents;
    private List<CourseAssignments> listOfCourseAssignments;
    private List<CourseTrainers> listOfCourseTrainers;
    
    public List<Course> getCourses() {
        return courses;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<CourseStudents> getStudentsPerCourses() {
        return listOfCourseStudents;
    }

    public List<CourseAssignments> getAssignmeentsPerCourses() {
        return listOfCourseAssignments;
    }

    public List<CourseTrainers> getTrainersPerCourses() {
        return listOfCourseTrainers;
    }
    
//    public void createSyntheticData(){
//        listOfCourseTrainers = new ArrayList();
//        listOfCourseStudents = new ArrayList();
//        listOfCourseAssignments = new ArrayList();
//        courses = new ArrayList();
//        Course courseJavaFull = new Course("CB-10", "Java", "Full-time", LocalDate.parse("2020-03-03"), LocalDate.parse("2020-06-05"));
//        courses.add(courseJavaFull);
//        Course courseJavaPart = new Course("CB-10", "Java", "Part-time", LocalDate.parse("2020-01-05"), LocalDate.parse("2020-06-10"));
//        courses.add(courseJavaPart);
//        Course courseJSPart = new Course("CB-11", "JavaScript", "Full-time", LocalDate.parse("2020-09-01"), LocalDate.parse("2021-01-10"));
//        courses.add(courseJSPart);
//        
//        // TRAINERS DATA
//        trainers = new ArrayList();
//        List<Trainer> trainersJavaFull = new ArrayList();
//        List<Trainer> trainersJavaPart = new ArrayList();
//        List<Trainer> trainersJavaScript = new ArrayList();
//        Trainer trainer1 = new Trainer("Tasos", "Lelakis", "Java");
//        Trainer trainer2 = new Trainer("George", "Pasparakis", "Wep-app Development");
//        Trainer trainer3 = new Trainer("John", "Papadopoulos", "JavaScript");
//        trainers.add(trainer1);
//        trainers.add(trainer2);
//        trainers.add(trainer3);
//        trainersJavaFull.add(trainer1);
//        trainersJavaFull.add(trainer2);
//        trainersJavaPart.add(trainer2);
//        trainersJavaPart.add(trainer3);
//        trainersJavaScript.add(trainer3);
//        listOfCourseTrainers.add(new CourseTrainers(courseJavaFull, trainersJavaFull));
//        listOfCourseTrainers.add(new CourseTrainers(courseJavaPart, trainersJavaPart));
//        listOfCourseTrainers.add(new CourseTrainers(courseJSPart, trainersJavaScript));
//        
//        // STUDENTS
//        students = new ArrayList();
//        List<Student> studentsJavaFull = new ArrayList();
//        List<Student> studentsJavaPart = new ArrayList();
//        List<Student> studentsJS = new ArrayList();
//        Student student1 = new Student("George", "Papadopoulos", LocalDate.parse("1991-07-10"), 2500d);
//        Student student2 = new Student("Orestis", "Tanis", LocalDate.parse("1989-05-05"), 2500d);
//        Student student3 = new Student("George", "Kourouzidis", LocalDate.parse("1993-11-11"), 2500d);
//        Student student4 = new Student("Stelios", "Dimitriou", LocalDate.parse("1988-10-08"), 2500d);
//        Student student5 = new Student("Petros", "Nikolopoulos", LocalDate.parse("1990-06-10"), 2500d);
//        students.add(student1);
//        students.add(student2);
//        students.add(student3);
//        students.add(student4);
//        students.add(student5);
//        studentsJavaFull.add(student1);
//        studentsJavaFull.add(student2);
//        studentsJavaFull.add(student3);
//        studentsJavaPart.add(student3);
//        studentsJavaPart.add(student2);
//        studentsJavaPart.add(student4);
//        studentsJS.add(student5);
//        studentsJS.add(student3);
//        listOfCourseStudents.add(new CourseStudents(courseJavaFull, studentsJavaFull));
//        listOfCourseStudents.add(new CourseStudents(courseJavaPart, studentsJavaPart));
//        listOfCourseStudents.add(new CourseStudents(courseJSPart, studentsJS));
//        
//        // ASSIGNMENTS
//        assignments = new ArrayList();
//        List<Assignment> assignmentsJavaFull = new ArrayList();
//        List<Assignment> assignmentsJavaPart = new ArrayList();
//        List<Assignment> assignmentsJS = new ArrayList();
//        Assignment assignmentJavaFull1 = new Assignment("Individual Project Part A CB-10 Java Full-Time", "Individual project description", LocalDate.parse("2020-03-24"), 75);
//        Assignment assignmentJavaFull2 = new Assignment("Individual Project Part B CB-10 Java Full-Time", "Individual project description", LocalDate.parse("2020-04-15"), 75);
//        Assignment assignmentJavaPart1 = new Assignment("Individual Project Part A CB-10 Java Part-Time", "Individual project description", LocalDate.parse("2020-05-25"), 75);
//        Assignment assignmentJavaPart2 = new Assignment("Individual Project Part B CB-10 Java Part-Time", "Team project description", LocalDate.parse("2020-06-15"), 75);
//        Assignment assignmentJS1 = new Assignment("Individual Project Part A CB-11 JavaScript Part-time project", "Individual project description", LocalDate.parse("2020-09-29"), 75);
//        Assignment assignmentJS2 = new Assignment("Individual Project Part B CB-11 JavaScript Part-time project", "Individual project description", LocalDate.parse("2020-10-16"), 75);
//        assignments.add(assignmentJavaFull1);
//        assignments.add(assignmentJavaFull2);
//        assignments.add(assignmentJavaPart1);
//        assignments.add(assignmentJavaPart2);
//        assignments.add(assignmentJS1);
//        assignments.add(assignmentJS2);
//        assignmentsJavaFull.add(assignmentJavaFull1);
//        assignmentsJavaFull.add(assignmentJavaFull2);
//        assignmentsJavaPart.add(assignmentJavaPart1);
//        assignmentsJavaPart.add(assignmentJavaPart2);
//        assignmentsJS.add(assignmentJS1);
//        assignmentsJS.add(assignmentJS2);
//        listOfCourseAssignments.add(new CourseAssignments(courseJavaFull, assignmentsJavaFull));
//        listOfCourseAssignments.add(new CourseAssignments(courseJavaPart, assignmentsJavaPart));
//        listOfCourseAssignments.add(new CourseAssignments(courseJSPart, assignmentsJS));
//    }
}
