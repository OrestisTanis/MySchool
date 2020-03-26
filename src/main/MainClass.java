
package main;

import bootcamp.core.Assignment;
import bootcamp.creators.StudentCreator;
import bootcamp.creators.CourseCreator;
import bootcamp.creators.AssignmentCreator;
import bootcamp.creators.TrainerCreator;
import bootcamp.core.Course;
import bootcamp.core.Student;
import bootcamp.core.Trainer;
import bootcamp.creators.list.CourseAssignmentsCreator;
import bootcamp.creators.list.CourseStudentsCreator;
import bootcamp.creators.list.CourseTrainersCreator;
import bootcamp.lists.CourseAssignments;
import bootcamp.lists.CourseStudents;
import bootcamp.lists.CourseTrainers;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class MainClass {
    static List<Course> courses = new ArrayList();
    static List<Trainer> trainers = new ArrayList();
    static List<Student> students = new ArrayList();
    static List<Assignment> assignments = new ArrayList();
    static List<CourseTrainers> listOfCourseTrainers = new ArrayList();
    static List<CourseStudents> listOfCourseStudents = new ArrayList();
    static List<CourseAssignments> listOfCourseAssignments = new ArrayList();
    static MenuState menuState; 
    enum MenuState { CREATION, INSERTION, EXITING }
    
    public static void main(String[] args) {
        Input.createScanner();
        String choice = "";
        menuState = MenuState.CREATION;
        
        // Greeting
        Printer.printWelcomeMessage();
        System.out.println("Do you want to create your own data? If you answer no, synthetic data will be used and printed. (Y/N)");
        choice = Input.getString("[yYNn]", "Y/N?");
        
        if(choice.equalsIgnoreCase("n")){
            createSyntheticData();
            printAll();
        }
        else {
            while (menuState != MenuState.EXITING) {
                if (menuState == MenuState.CREATION){
                    menuState = goToCreationMenu(menuState);
                }
                if (menuState == MenuState.INSERTION) {
                    menuState = goToInsertionMenu(menuState);
                }
            };
            printAll();
        }
        askForDate();
        Printer.printEndOfProgram();
        Input.closeScanner();
    }
    
    public static MenuState goToCreationMenu(MenuState menuState){
        System.out.println("\nWhat would you like to do?");
        ArrayList<String> options = Input.printOptions("Create Course", "Create Trainer", "Create Student", "Create Assignment", "Continue", "Exit");        
        int choice = Input.getOptionInt(options);
        switch (choice) {
            case 1:
                CourseCreator courseCreator = new CourseCreator();
                courses = courseCreator.createCourses(courses);
                //courses = courseCreator.getCourses();
                break;
            case 2:
                TrainerCreator trainerCreator = new TrainerCreator();
                trainers = trainerCreator.createTrainers(trainers);
                //trainers = trainerCreator.getTrainers();
                break;
            case 3:
                StudentCreator studentCreator = new StudentCreator();
                students = studentCreator.createStudents(students);
                //students = studentCreator.getStudents();
                break;
            case 4:
                AssignmentCreator assignmentCreator = new AssignmentCreator();
                assignments = assignmentCreator.createAssignments(assignments);
                //assignments = assignmentCreator.getAssignments();
                break;
            case 5:
                menuState = MenuState.INSERTION;
                break;
            default:
                menuState = MenuState.EXITING;
                break;
        }
        return menuState;            
    }
    
    public static MenuState goToInsertionMenu(MenuState menuState){
        System.out.println("\nWhat would you like to do now?");
        ArrayList<String> options = Input.printOptions("Insert Trainer to course", "Insert Student to course", "Insert Assignment to course", "Go Back", "Continue to Print", "Exit");                    
        int choice = Input.getOptionInt(options);
        switch (choice) {
            case 1:
                CourseTrainersCreator courseTrainersCreator = new CourseTrainersCreator();
                listOfCourseTrainers = courseTrainersCreator.run(courses, trainers,listOfCourseTrainers);
                //listOfCourseTrainers.addAll(newCourseTrainers);
                break;
            case 2:
                CourseStudentsCreator courseStudentsCreator = new CourseStudentsCreator();
                listOfCourseStudents = courseStudentsCreator.run(courses, students, listOfCourseStudents);
                //listOfCourseStudents.addAll(newCourseStudents);
                System.out.println("LIST OF COURSEASTUDS: " + listOfCourseStudents);
                break;
            case 3:
                CourseAssignmentsCreator courseAssignmentsCreator = new CourseAssignmentsCreator();
                listOfCourseAssignments = courseAssignmentsCreator.run(courses, assignments, listOfCourseAssignments);
                System.out.println("LIST OF COURSEASSIGNS: " + listOfCourseAssignments);
                System.out.println("LIST OF COURSEASTUDS: " + listOfCourseStudents);
                //listOfCourseAssignments.addAll(newCourseAssignments);
                break;
            case 4:
                menuState = MenuState.CREATION;
                break;
            case 5:
                menuState = MenuState.EXITING;
                break;
            default:
                menuState = MenuState.EXITING;
                break;
        }
        return menuState;
    }
    
    public static void goToPrintingMenu(){}
    
    public static void askForDate(){
        System.out.println("Lastly, enter a date to print the list of students who need to submit one \n" +
                            "or more assignments on the same calendar week: ");
        System.out.println("\nPlease enter assignment submission date (dd/MM/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String validDate = "2015-01-01";
        LocalDate assignmentSubDate = Input.getLocalDateAfter(LocalDate.parse(validDate),"dd/MM/yyyy", "Invalid date. Enter a valid date after " + LocalDate.parse(validDate).format(formatter) + " in the format of dd/MM/yyyy: ");
        Printer.printListOfStudentsWithAssignmentsInWeek(listOfCourseAssignments, listOfCourseStudents, students, assignmentSubDate);
    }
    
    public static void printAll(){
        Printer.printingListsIndication();
        Printer.printCourses(courses);
        Printer.printTrainers(trainers);
        Printer.printStudents(students);
        Printer.printAssignments(assignments);
        Printer.printCourseStudents(listOfCourseStudents);
        Printer.printCourseTrainers(listOfCourseTrainers);
        Printer.printCourseAssignments(listOfCourseAssignments);
        Printer.printCoursesPerStudent(listOfCourseStudents, students);
        Printer.printAssignmentsPerStudent(listOfCourseAssignments, listOfCourseStudents, students);
    }   
    
    private static void createSyntheticData256346342(){
        listOfCourseTrainers = new ArrayList();
        listOfCourseStudents = new ArrayList();
        listOfCourseAssignments = new ArrayList();
        courses = new ArrayList();
        Course courseJavaFull = new Course("CB-10", "Java", "Full-time", LocalDate.parse("2020-03-03"), LocalDate.parse("2020-06-05"));
        courses.add(courseJavaFull);
        Course courseJavaPart = new Course("CB-10", "Java", "Part-time", LocalDate.parse("2020-01-05"), LocalDate.parse("2020-06-10"));
        courses.add(courseJavaPart);
        Course courseJSPart = new Course("CB-11", "JavaScript", "Full-time", LocalDate.parse("2020-09-01"), LocalDate.parse("2021-01-10"));
        courses.add(courseJSPart);
        
        // TRAINERS DATA
        trainers = new ArrayList();
        List<Trainer> trainersJavaFull = new ArrayList();
        List<Trainer> trainersJavaPart = new ArrayList();
        List<Trainer> trainersJavaScript = new ArrayList();
        Trainer trainer1 = new Trainer("Tasos", "Lelakis", "Java");
        Trainer trainer2 = new Trainer("George", "Pasparakis", "Wep-app Development");
        Trainer trainer3 = new Trainer("John", "Papadopoulos", "JavaScript");
        trainers.add(trainer1);
        trainers.add(trainer2);
        trainers.add(trainer3);
        trainersJavaFull.add(trainer1);
        trainersJavaFull.add(trainer2);
        trainersJavaPart.add(trainer2);
        trainersJavaPart.add(trainer3);
        trainersJavaScript.add(trainer3);
        listOfCourseTrainers.add(new CourseTrainers(courseJavaFull, trainersJavaFull));
        listOfCourseTrainers.add(new CourseTrainers(courseJavaPart, trainersJavaPart));
        listOfCourseTrainers.add(new CourseTrainers(courseJSPart, trainersJavaScript));
        
        // STUDENTS
        students = new ArrayList();
        List<Student> studentsJavaFull = new ArrayList();
        List<Student> studentsJavaPart = new ArrayList();
        List<Student> studentsJS = new ArrayList();
        Student student1 = new Student("George", "Papadopoulos", LocalDate.parse("1991-07-10"), 2500d);
        Student student2 = new Student("Orestis", "Tanis", LocalDate.parse("1989-05-05"), 2500d);
        Student student3 = new Student("George", "Kourouzidis", LocalDate.parse("1993-11-11"), 2500d);
        Student student4 = new Student("Stelios", "Dimitriou", LocalDate.parse("1988-10-08"), 2500d);
        Student student5 = new Student("Petros", "Nikolopoulos", LocalDate.parse("1990-06-10"), 2500d);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        studentsJavaFull.add(student1);
        studentsJavaFull.add(student2);
        studentsJavaFull.add(student3);
        studentsJavaPart.add(student3);
        studentsJavaPart.add(student2);
        studentsJavaPart.add(student4);
        studentsJS.add(student5);
        studentsJS.add(student3);
        listOfCourseStudents.add(new CourseStudents(courseJavaFull, studentsJavaFull));
        listOfCourseStudents.add(new CourseStudents(courseJavaPart, studentsJavaPart));
        listOfCourseStudents.add(new CourseStudents(courseJSPart, studentsJS));
        
        // ASSIGNMENTS
        assignments = new ArrayList();
        List<Assignment> assignmentsJavaFull = new ArrayList();
        List<Assignment> assignmentsJavaPart = new ArrayList();
        List<Assignment> assignmentsJS = new ArrayList();
        Assignment assignmentJavaFull1 = new Assignment("Individual Project Part A CB-10 Java Full-Time", "Individual project description", LocalDate.parse("2020-03-24"), 75);
        Assignment assignmentJavaFull2 = new Assignment("Individual Project Part B CB-10 Java Full-Time", "Individual project description", LocalDate.parse("2020-04-15"), 75);
        Assignment assignmentJavaPart1 = new Assignment("Individual Project Part A CB-10 Java Part-Time", "Individual project description", LocalDate.parse("2020-05-25"), 75);
        Assignment assignmentJavaPart2 = new Assignment("Individual Project Part B CB-10 Java Part-Time", "Team project description", LocalDate.parse("2020-06-15"), 75);
        Assignment assignmentJS1 = new Assignment("Individual Project Part A CB-11 JavaScript Part-time project", "Individual project description", LocalDate.parse("2020-09-29"), 75);
        Assignment assignmentJS2 = new Assignment("Individual Project Part B CB-11 JavaScript Part-time project", "Individual project description", LocalDate.parse("2020-10-16"), 75);
        assignments.add(assignmentJavaFull1);
        assignments.add(assignmentJavaFull2);
        assignments.add(assignmentJavaPart1);
        assignments.add(assignmentJavaPart2);
        assignments.add(assignmentJS1);
        assignments.add(assignmentJS2);
        assignmentsJavaFull.add(assignmentJavaFull1);
        assignmentsJavaFull.add(assignmentJavaFull2);
        assignmentsJavaPart.add(assignmentJavaPart1);
        assignmentsJavaPart.add(assignmentJavaPart2);
        assignmentsJS.add(assignmentJS1);
        assignmentsJS.add(assignmentJS2);
        listOfCourseAssignments.add(new CourseAssignments(courseJavaFull, assignmentsJavaFull));
        listOfCourseAssignments.add(new CourseAssignments(courseJavaPart, assignmentsJavaPart));
        listOfCourseAssignments.add(new CourseAssignments(courseJSPart, assignmentsJS));
    }
    
    private static void createSyntheticData(){
        SyntheticData data = new SyntheticData();
        data.createSyntheticData();
        courses = data.getCourses();
        trainers = data.getTrainers();
        students = data.getStudents();
        assignments = data.getAssignments();
        listOfCourseStudents = data.getStudentsPerCourses();
        listOfCourseTrainers = data.getTrainersPerCourses();
        listOfCourseAssignments = data.getAssignmeentsPerCourses();
    }
}
