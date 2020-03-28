package main;

import interfaces.DateFormatable;
import appstate.UserData;
import bootcamp.core.Assignment;
import bootcamp.core.Course;
import bootcamp.core.Student;
import bootcamp.core.Trainer;
import bootcamp.lists.CourseAssignments;
import bootcamp.lists.CourseStudents;
import bootcamp.lists.CourseTrainers;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Printer implements DateFormatable {
    private final static int numberOfStars = 150;
            
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

    public static void printStudents(Set<Student> setOfStudents) {
        printStarsBeforeAndAfterString("PRINTING LIST OF ALL STUDENTS", numberOfStars);
        if (setOfStudents.size() == 0) {
            System.out.println("No students listed.\n");
            return;
        }
        int i = 0;
        for (Student student : setOfStudents) {
            System.out.printf("%d. %s %s\n", ++i, student.getFirstName(), student.getLastName());
        }
        System.out.println("");
    }

    public static void printTrainers(Set<Trainer> setOfTrainers) {
        //System.out.println("\n************ PRINTING LIST OF TRAINERS **************");
        printStarsBeforeAndAfterString("PRINTING LIST OF ALL TRAINERS", numberOfStars);
        if (setOfTrainers.size() == 0) {
            System.out.println("No trainers listed.\n");
            return;
        }
        int i = 0;
        for (Trainer trainer : setOfTrainers) {
            System.out.printf("%d. %s %s\n", ++i, trainer.getFirstName(), trainer.getLastName());
        }
        System.out.println("");
    }

    public static void printAssignments(Set<Assignment> setOfAssignments) {
        //System.out.println("\n************ PRINTING LIST OF ASSIGNMENTS **************");
        printStarsBeforeAndAfterString("PRINTING LIST OF ALL ASSIGNMENTS", numberOfStars);
        if (setOfAssignments.size() == 0) {
            System.out.println("No assignments listed.\n");
            return;
        }
        int i = 0;
        for (Assignment assignment : setOfAssignments) {
            System.out.printf("%d. %s, sub.Date: %s\n", ++i, assignment.getTitle(), assignment.getSubDateTime().format(formatter));
        }
        System.out.println("");
    }

    public static void printCourses(Set<Course> setOfCourses) {
        printStarsBeforeAndAfterString("PRINTING LIST OF ALL COURSES", numberOfStars);
        if (setOfCourses.size() == 0) {
            System.out.println("No courses listed.\n");
            return;
        }
        int i = 0;
        for (Course course : setOfCourses) {
            System.out.printf("%d. %s %s %s\n", ++i, course.getTitle(), course.getStream(), course.getType());
        }
        System.out.println("");
    }

    public static void printCourseStudents(Set<CourseStudents> setOfStudentsPerCourse) {
        for (CourseStudents studentsPerCourse : setOfStudentsPerCourse) {
            Course course = studentsPerCourse.getCourse();
            Set<Student> setOfStudents = studentsPerCourse.getSetOfComponents();
            printStarsBeforeAndAfterString(String.format("PRINTING LIST OF STUDENTS IN COURSE %s / %s / %s", course.getTitle().toUpperCase(), course.getStream().toUpperCase(), course.getType().toUpperCase()), numberOfStars);
            if (setOfStudents.size() == 0){
                System.out.println("No students listed.\n");
            }
            else {
                int i = 0;
                for (Student student: setOfStudents){
                     System.out.printf("%d. %s %s\n", ++i, student.getFirstName(), student.getLastName());
                }
            }
            System.out.println("");
        }
       
    }

    public static void printCourseTrainers(Set<CourseTrainers> setOfTrainersPerCourse) {
        for (CourseTrainers trainersPerCourse : setOfTrainersPerCourse) {
            Course course = trainersPerCourse.getCourse();
            Set<Trainer> setOfTrainers = trainersPerCourse.getSetOfComponents();
            printStarsBeforeAndAfterString(String.format("PRINTING LIST OF TRAINERS IN COURSE %s / %s / %s", course.getTitle().toUpperCase(), course.getStream().toUpperCase(), course.getType().toUpperCase()), numberOfStars);
            if (setOfTrainers.size() == 0) {
                System.out.println("No trainers listed.\n");
            } 
            else {
                int i = 0;
                for (Trainer trainer: setOfTrainers) {
                    System.out.printf("%d. %s %s\n", ++i, trainer.getFirstName(), trainer.getLastName());
                }
            }
            System.out.println("");
        }
    }

    public static void printCourseAssignments(Set<CourseAssignments> setOfAssignmentsPerCourse) {
        for (CourseAssignments assignmentsPerCourse : setOfAssignmentsPerCourse) {
            Set<Assignment> setOfAssignments = assignmentsPerCourse.getSetOfComponents();
            Course course = assignmentsPerCourse.getCourse();
            printStarsBeforeAndAfterString(String.format("PRINTING LIST OF ASSIGNMENTS IN COURSE %s / %s / %s", course.getTitle().toUpperCase(), course.getStream().toUpperCase(), course.getType().toUpperCase()), numberOfStars);            
            if (setOfAssignments.size() == 0) {
                System.out.println("No assignments listed.\n");
            } else {
                int i = 0;
                for (Assignment assignment : setOfAssignments) {
                    System.out.printf("%d. %s, sub.time: %s\n", ++i, assignment.getTitle(), assignment.getSubDateTime().format(formatter));
                }
            }
            System.out.println("");
        }
    }

    public static void printCoursesPerStudent(Set<CourseStudents> setOfstudentsPerCourse, Set<Student> allStudents) {
        Map<Student, Set<Course>> coursesPerStudentMap = getCoursesPerStudentMap(setOfstudentsPerCourse, allStudents);
        Set<Entry<Student, Set<Course>>> entrySet = coursesPerStudentMap.entrySet();
        printStarsBeforeAndAfterString("PRINTING LIST OF STUDENTS BELONING TO MORE THAN ONE COURSE", numberOfStars);
        int i = 0;
        for (Entry entry : entrySet) {
            if (((Set<Course>) entry.getValue()).size() > 1) {
                Set<Course> listOfCourses = (Set<Course>) entry.getValue();
                int numberOfCourses = listOfCourses.size();
                System.out.printf("%d. %s belongs to (%d) courses:\n", ++i, entry.getKey(), numberOfCourses);
                int j = 0;
                for (Course course : listOfCourses){
                    System.out.printf("\t %d. %s\n", ++j, course);
                }
                 System.out.println("");
            }
        }
        if(i == 0){
            System.out.println("No students belong to more than 1 courses.\n");
        }
    }

    private static Map<Student, Set<Course>> getCoursesPerStudentMap(Set<CourseStudents> setOfStudentsPerCourse, Set<Student> allStudents) {
        Map<Student, Set<Course>> coursesPerStudentMap = new HashMap();
        for (Student student : allStudents) { // for every student
            for (CourseStudents studentsPerCourse : setOfStudentsPerCourse) { // for every course 
                // If the student belongs in this course
                if (studentsPerCourse.containedInSet(student)) {
                    Set<Course> courses = new HashSet();
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

    public static void printAssignmentsPerStudent(UserData userData) {
        Set<CourseAssignments> setOfAssignmentsPerCourse = userData.getSetOfAssignmentsPerCourse();
        Set<CourseStudents> setOfStudentsPerCourse = userData.getSetOfStudentsPerCourse();
        Set<Student> allStudents = userData.getSetOfStudents();
        Map<Student, Set<Assignment>> assignmentsPerStudentMap = getAssignmentsPerStudentMap(setOfAssignmentsPerCourse, setOfStudentsPerCourse, allStudents);        
        Set<Entry<Student, Set<Assignment>>> entrySet = assignmentsPerStudentMap.entrySet();
        printStarsBeforeAndAfterString("PRINTING ASSIGNMENTS PER STUDENT", numberOfStars);
        int i = 0;
        for (Entry entry : entrySet) {
            if (((Set<Course>) entry.getValue()).size() > 0) {
                Set<Assignment> listOfAssignments = ((Set<Assignment>)entry.getValue());
                int numberOfAssignments = listOfAssignments.size();
                System.out.printf("%d. %s has (%d) assignments: \n", ++i, entry.getKey(), numberOfAssignments);
                int j = 0;
                for (Assignment assignment : listOfAssignments){
                    System.out.printf("\t %d. %s\n", ++j, assignment);
                }
                System.out.println("");
            }
        }
        if (i == 0){
            System.out.println("No assignments assigned to students.\n");
        }
    }

    private static Map<Student, Set<Assignment>> getAssignmentsPerStudentMap(Set<CourseAssignments> setOfAssignmentsPerCourse, Set<CourseStudents> setOfStudentsPerCourse, Set<Student> allStudents) {
        Map<Student, Set<Course>> coursesPerStudentMap = getCoursesPerStudentMap(setOfStudentsPerCourse, allStudents);
        Map<Student, Set<Assignment>> assignmentsPerStudentMap = new HashMap();
        for (Student student : allStudents) {
            for (CourseAssignments assignmentsPerCourse : setOfAssignmentsPerCourse) { //for every course
                if (coursesPerStudentMap.get(student).contains(assignmentsPerCourse.getCourse())) { //if student is in the course
                    Set<Assignment> assignments = new HashSet();
                    // If student is already added to the map
                    if (assignmentsPerStudentMap.containsKey(student)) {
                        assignments = assignmentsPerStudentMap.get(student);
                        // add the new assignments and replace the value in the map
                        assignments.addAll(assignmentsPerCourse.getSetOfComponents());
                        assignmentsPerStudentMap.put(student, assignments); // update the entry
                    } else { // if student is not already in the map, add the first entry
                        assignments.addAll(assignmentsPerCourse.getSetOfComponents());
                        assignmentsPerStudentMap.put(student, assignments);
                    }
                }
            }
        }
        return assignmentsPerStudentMap;
    }

    public static void printListOfStudentsWithAssignmentsInWeek(UserData userData, LocalDate inputDate) {
        Set<CourseAssignments> setOfAssignmentsPerCourse = userData.getSetOfAssignmentsPerCourse();
        Set<CourseStudents> setOfStudentsPerCourse = userData.getSetOfStudentsPerCourse();
        Set<Student> setOfAllStudents = userData.getSetOfStudents();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("");
        printStarsBeforeAndAfterString(String.format("PRINTING LIST OF STUDENTS THAT MUST SUBMIT ASSIGNMENTS IN THE SAME CALENDAR WEEK AS %s %s",inputDate.getDayOfWeek().toString() ,inputDate.format(formatter)), numberOfStars);        
        LocalDate firstDayOfWeek = getFirstDayOfWeek(inputDate);
        LocalDate lastDayOfWeek = getLastDayOfWeekFromFirst(firstDayOfWeek);
        Map<Student, Set<Assignment>> assignmentsPerStudentMap = getAssignmentsPerStudentMap(setOfAssignmentsPerCourse, setOfStudentsPerCourse, setOfAllStudents);       
        Set<Entry<Student, Set<Assignment>>> assignmentsPerStudentSet = assignmentsPerStudentMap.entrySet();
        int i = 0;
        for (Entry entry : assignmentsPerStudentSet) {
            Set<Assignment> assignmentsPerStudent = (Set<Assignment>)entry.getValue();
            for (Assignment assignment : assignmentsPerStudent){
                LocalDate assignmentSubDate = assignment.getSubDateTime();
                boolean afterFirstDayOfWeek = assignmentSubDate.isAfter(firstDayOfWeek) || assignmentSubDate.isEqual(firstDayOfWeek);
                boolean beforeLastDayOfWeek = assignmentSubDate.isBefore(lastDayOfWeek) || assignmentSubDate.isEqual(lastDayOfWeek);
                if (afterFirstDayOfWeek && beforeLastDayOfWeek){
                    Student student = (Student)entry.getKey();
                    System.out.printf("%d. %s %s, Assignment title: %s\n", ++i, student.getFirstName(), student.getLastName(), assignment.getTitle());
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
        return firstDateOfWeek;
    }

    public static LocalDate getLastDayOfWeekFromFirst(LocalDate firstDateOfWeek) {
        return firstDateOfWeek.plusDays(4);
    }
}
