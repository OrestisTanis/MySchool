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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author orestis
 */
public class Printer {
    private static int numberOfStars = 150;
            
    public Printer() {

    }
    
    public static void printEndOfProgram(){
        System.out.println("\n");
        printMessageAroundDoubleStars("Thank you for using myBootcamp!", numberOfStars);
        printMessageAroundStars("End of application", numberOfStars);
    }

    public static void printStarsBeforeAndAfterString(String message, int numberOfStars) {
        char[] charArray = message.toCharArray();
        numberOfStars -= 1;
        String result = "";
        for (char ch : charArray) {
            numberOfStars--;
        }
        for (int i = 0; i < numberOfStars; i++) {
            if (i != numberOfStars / 2) {
                result += '*';
            } else {
                result += String.format(" %s ", message);
            }
        }
        System.out.println(result);
    }

    public static void printMessageAroundStars(String message, int numberOfStars) {
        printStars(numberOfStars);
        printStarsBeforeAndAfterString(message, numberOfStars);
        printStars(numberOfStars);
    }
    
    public static void printMessageAroundDoubleStars(String message, int numberOfStars){
        printStars(numberOfStars);
        printMessageAroundStars(message, numberOfStars);
        printStars(numberOfStars);
    }

    public static void printStars(int numberOfStars) {
        String result = "";
        for (int i = 0; i < numberOfStars; i++) {
            result += '*';
        }
        System.out.println(result);
    }

    public static void printWelcomeMessage() {
        printMessageAroundDoubleStars("MyBootCamp v1.0", numberOfStars);
        System.out.println("");
        System.out.println("Welcome to MyBootCamp!");
        System.out.println("");
    }

    public static void printingListsIndication() {
        System.out.println("");
        printMessageAroundStars("PRINTING LISTS", numberOfStars);
        System.out.println("");
    }

    public static void printStudents(List list) {
        printStarsBeforeAndAfterString("PRINTING LIST OF ALL STUDENTS", numberOfStars);
        if (list.size() == 0) {
            System.out.println("No students listed.\n");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Student student = (Student) list.get(i);
            System.out.printf("%d. %s %s\n", i + 1, student.getFirstName(), student.getLastName());
        }
        System.out.println("");
    }

    public static void printTrainers(List list) {
        //System.out.println("\n************ PRINTING LIST OF TRAINERS **************");
        printStarsBeforeAndAfterString("PRINTING LIST OF ALL TRAINERS", numberOfStars);
        if (list.size() == 0) {
            System.out.println("No trainers listed.\n");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Trainer trainer = (Trainer) list.get(i);
            System.out.printf("%d. %s %s\n", i + 1, trainer.getFirstName(), trainer.getLastName());
        }
        System.out.println("");
    }

    public static void printAssignments(List<Assignment> list) {
        //System.out.println("\n************ PRINTING LIST OF ASSIGNMENTS **************");
        printStarsBeforeAndAfterString("PRINTING LIST OF ALL ASSIGNMENTS", numberOfStars);
        if (list.size() == 0) {
            System.out.println("No assignments listed.\n");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Assignment assignment = list.get(i);
            System.out.printf("%d. %s, sub.Date: %s\n", i + 1, assignment.getTitle(), assignment.getSubDateTime());
        }
        System.out.println("");
    }

    public static void printCourses(List list) {
        //System.out.println("\n************ PRINTING LIST OF COURSES **************");
        printStarsBeforeAndAfterString("PRINTING LIST OF ALL COURSES", numberOfStars);
        if (list.size() == 0) {
            System.out.println("No courses listed.\n");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Course course = (Course) list.get(i);
            System.out.printf("%d. %s %s %s\n", i + 1, course.getTitle(), course.getStream(), course.getType());
        }
        System.out.println("");
    }

    public static void printCourseStudents(List list) {
        Student student = null;
        for (int i = 0; i < list.size(); i++) {
            CourseStudents courseStudents = (CourseStudents) list.get(i);
            Course course = courseStudents.getCourse();
            //System.out.printf("\n************ PRINTING LIST OF );
            printStarsBeforeAndAfterString(String.format("PRINTING LIST OF STUDENTS IN COURSE %s / %s / %s", course.getTitle().toUpperCase(), course.getStream().toUpperCase(), course.getType().toUpperCase()), numberOfStars);
            List<Student> studentList = courseStudents.getList();
            if (studentList.size() == 0) {
                System.out.println("No students listed.\n");
            } else {
                for (int j = 0; j < studentList.size(); j++) {
                    student = (Student) studentList.get(j);
                    System.out.printf("%d. %s %s\n", j + 1, student.getFirstName(), student.getLastName());
                }
                System.out.println("");
            }
        }
    }

    public static void printCourseTrainers(List<CourseTrainers> list) {
        Trainer trainer = null;
        for (int i = 0; i < list.size(); i++) {
            CourseTrainers curseTrainers = list.get(i);
            Course course = curseTrainers.getCourse();
            //System.out.printf("\n************ PRINTING LIST OF TRAINERS IN COURSE %s / %s / %s **************\n", course.getTitle().toUpperCase(), course.getStream().toUpperCase(), course.getType().toUpperCase());
            printStarsBeforeAndAfterString(String.format("PRINTING LIST OF TRAINERS IN COURSE %s / %s / %s", course.getTitle().toUpperCase(), course.getStream().toUpperCase(), course.getType().toUpperCase()), numberOfStars);
            List<Trainer> trainerList = curseTrainers.getList();
            if (trainerList.size() == 0) {
                System.out.println("No trainers listed.\n");
            } else {
                for (int j = 0; j < trainerList.size(); j++) {
                    trainer = (Trainer) trainerList.get(j);
                    System.out.printf("%d. %s %s\n", j + 1, trainer.getFirstName(), trainer.getLastName());
                }
            }
            System.out.println("");
        }
    }

    public static void printCourseAssignments(List<CourseAssignments> list) {
        Assignment assignment = null;
        for (int i = 0; i < list.size(); i++) {
            CourseAssignments courseAssignments = list.get(i);
            Course course = courseAssignments.getCourse();
            //System.out.printf("\n************ PRINTING LIST OF ASSIGNMENTS IN COURSE %s / %s / %s **************\n", course.getTitle().toUpperCase(), course.getStream().toUpperCase(), course.getType().toUpperCase());
            printStarsBeforeAndAfterString(String.format("PRINTING LIST OF ASSIGNMENTS IN COURSE %s / %s / %s", course.getTitle().toUpperCase(), course.getStream().toUpperCase(), course.getType().toUpperCase()), numberOfStars);
            List<Assignment> assignmentList = courseAssignments.getList();
            if (assignmentList.size() == 0) {
                System.out.println("No assignments listed.\n");
            } else {
                for (int j = 0; j < assignmentList.size(); j++) {
                    assignment = (Assignment) assignmentList.get(j);
                    System.out.printf("%d. %s, sub.time: %s\n", i + 1, assignment.getTitle(), assignment.getSubDateTime());
                }
            }
            System.out.println("");
        }
    }

    public static void printCoursesPerStudent(List<CourseStudents> studentsPerCourseList, List<Student> allStudents) {
        Map<Student, List<Course>> coursesPerStudentMap = getCoursesPerStudentMap(studentsPerCourseList, allStudents);
        Set<Entry<Student, List<Course>>> entrySet = coursesPerStudentMap.entrySet();
        printStarsBeforeAndAfterString("PRINTING STUDENTS BELONING TO MORE THAN ONE COURSE", numberOfStars);
        int i = 0;
        for (Entry entry : entrySet) {
            if (((List<Course>) entry.getValue()).size() > 1) {
                List<Course> listOfCourses = (List<Course>) entry.getValue();
                int numberOfCourses = listOfCourses.size();
                System.out.printf("%d. %s belongs to (%d) courses:\n", ++i, entry.getKey(), numberOfCourses);
                for (int j = 0; j < numberOfCourses; j++){
                    System.out.printf("\t %d. %s\n", j + 1, listOfCourses.get(j));
                }
                System.out.println("");
            }
        }
        if(i == 0){
            System.out.println("No students belong to more than 1 courses.\n");
        }
    }

    private static Map<Student, List<Course>> getCoursesPerStudentMap(List<CourseStudents> studentsPerCourseList, List<Student> allStudents) {
        Map<Student, List<Course>> coursesPerStudentMap = new HashMap();
        for (Student student : allStudents) { // for every student
            for (CourseStudents studentsPerCourse : studentsPerCourseList) { // for every course 
                // If the student belongs in this course
                if (studentsPerCourse.containedInList(student)) {
                    List<Course> courses = new ArrayList();
                    // If student is already added to the map
                    if (coursesPerStudentMap.containsKey(student)) {
                        courses = coursesPerStudentMap.get(student);
                        // add the new course and replace the value in the map
                        courses.add(studentsPerCourse.getCourse());
                        coursesPerStudentMap.put(student, courses); // update the entry
                    } else { // if student is not already in the map, add the first entry
                        courses.add(studentsPerCourse.getCourse());
                        coursesPerStudentMap.put(student, courses);
                    }
                }
            }
        }
        return coursesPerStudentMap;
    }

    public static void printAssignmentsPerStudent(List<CourseAssignments> listOfAssignmentsPerCourse, List<CourseStudents> listOfStudentsPerCourse, List<Student> allStudents) {
        Map<Student, List<Assignment>> assignmentsPerStudentMap = getAssignmentsPerStudentMap(listOfAssignmentsPerCourse, listOfStudentsPerCourse, allStudents);
        Set<Entry<Student, List<Assignment>>> entrySet = assignmentsPerStudentMap.entrySet();
        printStarsBeforeAndAfterString("PRINTING ASSIGNMENTS PER STUDENT", numberOfStars);
        //System.out.println("\n*************** PRINTING ASSIGNMENTS PER STUDENT *************");
        int i = 0;
        for (Entry entry : entrySet) {
            if (((List<Course>) entry.getValue()).size() > 0) {
                List<Assignment> listOfAssignments = ((List<Assignment>)entry.getValue());
                int numberOfAssignments = listOfAssignments.size();
                System.out.printf("%d. %s has (%d) assignments: \n", ++i, entry.getKey(), numberOfAssignments);
                for (int j = 0; j < numberOfAssignments; j++){
                    System.out.printf("\t %d. %s\n", j + 1, listOfAssignments.get(j));
                }
                System.out.println("");
            }
        }
        if (i == 0){
            System.out.println("No assignments assigned to students.\n");
        }
    }

    private static Map<Student, List<Assignment>> getAssignmentsPerStudentMap(List<CourseAssignments> listOfAssignmentsPerCourse, List<CourseStudents> listOfStudentsPerCourse, List<Student> allStudents) {
        Map<Student, List<Course>> coursesPerStudentMap = getCoursesPerStudentMap(listOfStudentsPerCourse, allStudents);
        Map<Student, List<Assignment>> assignmentsPerStudentMap = new HashMap();
        for (Student student : allStudents) {
            for (CourseAssignments assignmentsPerCourse : listOfAssignmentsPerCourse) { //for every course
                if (coursesPerStudentMap.get(student).contains(assignmentsPerCourse.getCourse())) { //if student is in the course
                    List<Assignment> assignments = new ArrayList();
                    // If student is already added to the map
                    if (assignmentsPerStudentMap.containsKey(student)) {
                        assignments = assignmentsPerStudentMap.get(student);
                        // add the new assignments and replace the value in the map
                        assignments.addAll(assignmentsPerCourse.getList());
                        assignmentsPerStudentMap.put(student, assignments); // update the entry
                    } else { // if student is not already in the map, add the first entry
                        assignments.addAll(assignmentsPerCourse.getList());
                        assignmentsPerStudentMap.put(student, assignments);
                    }
                }
            }
        }
        return assignmentsPerStudentMap;
    }

    public static void printListOfStudentsWithAssignmentsInWeek(List<CourseAssignments> listOfAssignmentsPerCourse, List<CourseStudents> listOfStudentsPerCourse, List<Student> allStudents, LocalDate inputDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("");
        printStarsBeforeAndAfterString(String.format("PRINTING LIST OF STUDENTS THAT MUST SUBMIT ASSIGNMENTS IN THE SAME CALENDAR WEEK AS %s", inputDate.format(formatter)), numberOfStars);        
        LocalDate firstDayOfWeek = getFirstDayOfWeek(inputDate);
        LocalDate lastDayOfWeek = getLastDayOfWeekFromFirst(firstDayOfWeek);
        Map<Student, List<Assignment>> assignmentsPerStudentMap = getAssignmentsPerStudentMap(listOfAssignmentsPerCourse, listOfStudentsPerCourse, allStudents);       
        Set<Entry<Student, List<Assignment>>> assignmentsPerStudentSet = assignmentsPerStudentMap.entrySet();
        int i = 0;
        for (Entry entry : assignmentsPerStudentSet) {
            List<Assignment> assignmentsPerStudent = (List<Assignment>)entry.getValue();
            for (Assignment assignment : assignmentsPerStudent){
                LocalDate assignmentSubDate = assignment.getSubDateTime();
                boolean afterFirstDayOfWeek = assignmentSubDate.isAfter(firstDayOfWeek) || assignmentSubDate.isEqual(firstDayOfWeek);
                boolean beforeLastDayOfWeek = assignmentSubDate.isBefore(lastDayOfWeek) || assignmentSubDate.isEqual(lastDayOfWeek);
                if (afterFirstDayOfWeek && beforeLastDayOfWeek){
                    Student student = (Student)entry.getKey();
                    System.out.printf("%d. %s %s\n", ++i, student.getFirstName(), student.getLastName());
                }
            }
        }
        if (i == 0){
            System.out.println("No students must submit assignments during this calendar week.\n");
        }
    }

    public static LocalDate getFirstDayOfWeek(LocalDate date) {
        LocalDate firstDateOfWeek = date;
        while (firstDateOfWeek.getDayOfWeek() != DayOfWeek.MONDAY) {
            firstDateOfWeek = firstDateOfWeek.minusDays(1);
        }
        //System.out.println("IS MONDAY?: " + firstDateOfWeek);
        return firstDateOfWeek;
    }

    public static LocalDate getLastDayOfWeekFromFirst(LocalDate firstDateOfWeek) {
        return firstDateOfWeek.plusDays(4);
    }

}
