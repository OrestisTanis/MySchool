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
        //String choice = "";
        menuState = MenuState.CREATION;
        
        // Greeting
        Printer.printWelcomeMessage();
        System.out.println("Do you want to create your own data? If you answer no, synthetic data will be used and printed. (Y/N)");
        String choice = Input.getString("[yYNn]", "Y/N?");
        
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
                break;
            case 2:
                TrainerCreator trainerCreator = new TrainerCreator();
                trainers = trainerCreator.createTrainers(trainers);
                break;
            case 3:
                StudentCreator studentCreator = new StudentCreator();
                students = studentCreator.createStudents(students);
                break;
            case 4:
                AssignmentCreator assignmentCreator = new AssignmentCreator();
                assignments = assignmentCreator.createAssignments(assignments);
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
                break;
            case 2:
                CourseStudentsCreator courseStudentsCreator = new CourseStudentsCreator();
                listOfCourseStudents = courseStudentsCreator.run(courses, students, listOfCourseStudents);
                break;
            case 3:
                CourseAssignmentsCreator courseAssignmentsCreator = new CourseAssignmentsCreator();
                listOfCourseAssignments = courseAssignmentsCreator.run(courses, assignments, listOfCourseAssignments);
                break;
            case 4:
                menuState = MenuState.CREATION;
                break;
            case 5:
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
