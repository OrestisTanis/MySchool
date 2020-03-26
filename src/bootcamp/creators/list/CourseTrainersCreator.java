/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.creators.list;

import bootcamp.core.Course;
import bootcamp.core.Trainer;
import bootcamp.lists.CourseTrainers;
import java.util.List;
import main.Input;

/**
 *
 * @author orestis
 */
public class CourseTrainersCreator {
//    private List<Course> listOfAvailableCourses;
//    private List<Trainer> listOfAvailableTrainers;
//    private static List<CourseTrainers> listOfCourseTrainers;
    
    /* Constructor */
//    public CourseTrainersCreator(List<Course> listOfCourses, List<Trainer> trainers) {
//        this.listOfAvailableCourses = listOfCourses;
//        this.listOfAvailableTrainers = trainers;
//    }
    
     public CourseTrainersCreator(){
         
     }
    
    /* Getter */
//    public List<CourseTrainers> getListOfCourseTrainers(){
//        if (listOfCourseTrainers == null){
//            listOfCourseTrainers = new ArrayList();
//        }
//        return listOfCourseTrainers;
//    }
    
   
     
    public List<CourseTrainers> run(List<Course> listOfAvailableCourses, List<Trainer> listOfAvailableTrainers, List<CourseTrainers> listOfTrainersPerCourse){
//        Trainer trainer;
//        Course course;
//        int choiceNum;
        String choice = "Y";
        //CourseTrainers courseTrainers = null;
        
        while(choice.equalsIgnoreCase("Y")){
            // No trainers available to assign
            if (listOfAvailableTrainers.isEmpty()){
                System.out.println("No available trainers to assign. Returning to main menu.");
                //choice = "N";
                return listOfTrainersPerCourse;
            }
            
            // No courses available to assign trainers to
            if (listOfAvailableCourses.isEmpty()){
              System.out.println("No available course to assign trainers to. Returning to main menu.");
              //choice = "N";
              return listOfTrainersPerCourse;
            }
                       
//            System.out.println("\nChoose a trainer to assign to a course: ");
//            Input.printOptions(listOfAvailableTrainers);
//            choiceNum = Input.getOptionInt(listOfAvailableTrainers);
//            // Save trainer selected by the user
//            trainer = listOfAvailableTrainers.get(choiceNum - 1);
            Trainer trainer = getTrainerFromUser(listOfAvailableTrainers);
           
//            System.out.printf("\nChoose a course to assign trainer %s to:\n", trainer);
//            Input.printOptions(listOfAvailableCourses);
//            choiceNum = Input.getOptionInt(listOfAvailableCourses);
//            course = listOfAvailableCourses.get(choiceNum - 1);
            Course course = getCourseFromUser(trainer, listOfAvailableCourses);

//            boolean trainerAlreadyAdded = trainerIsAlreadyInList(trainer, listOfTrainersPerCourse);
//            if (trainerAlreadyAdded) {
//                System.out.printf("Trainer %s %s is already assigned to course %s/%s/%s!%n", trainer.getFirstName(), trainer.getLastName(), course.getTitle(), course.getStream(), course.getType());
//            }
//            else if (listOfTrainersPerCourse.isEmpty()){                
//                CourseTrainers trainersPerCourse = addTrainerToNewCourse(course, trainer);
//                listOfTrainersPerCourse.add(trainersPerCourse);
//                System.out.printf("Trainer %s %s successfully added to course %s/%s/%s!%n", trainer.getFirstName(), trainer.getLastName(), course.getTitle(), course.getStream(), course.getType());
//            }
//            else {
//                int courseIndexInList = getCourseTrainersIndexInList(course, listOfTrainersPerCourse);
//                if (courseIndexInList > -1){
//                    listOfTrainersPerCourse.get(courseIndexInList).addToLisT(trainer);
//                }
//                else{
//                    CourseTrainers trainersPerCourse = addTrainerToNewCourse(course, trainer);
//                    listOfTrainersPerCourse.add(trainersPerCourse);
//                }
//                System.out.printf("Trainer %s %s successfully added to course %s/%s/%s!%n", trainer.getFirstName(), trainer.getLastName(), course.getTitle(), course.getStream(), course.getType());                
//            }
            listOfTrainersPerCourse = addTrainerToTrainersPerCourseList(trainer, course, listOfTrainersPerCourse);
            System.out.println("\nDo you want to insert another Trainer to a course? (Y/N)");
            choice = Input.getString("[yYnN]", "Y/N?");
        }
        return listOfTrainersPerCourse;
    }
    
     public Trainer getTrainerFromUser(List<Trainer> listOfAvailableTrainers){
        System.out.println("\nChoose a trainer to assign to a course: ");
        Input.printOptions(listOfAvailableTrainers);
        int choiceNum = Input.getOptionInt(listOfAvailableTrainers);
        // Save trainer selected by the user
        Trainer trainer = listOfAvailableTrainers.get(choiceNum - 1); 
        return trainer;
    }
    
    public Course getCourseFromUser(Trainer trainer, List<Course> listOfAvailableCourses){
        System.out.printf("\nChoose a course to assign trainer %s to:\n", trainer);
        Input.printOptions(listOfAvailableCourses);
        int choiceNum = Input.getOptionInt(listOfAvailableCourses);
        Course course = listOfAvailableCourses.get(choiceNum - 1);
        return course;
    }
    
    public List<CourseTrainers> addTrainerToTrainersPerCourseList(Trainer trainer, Course course, List<CourseTrainers> listOfTrainersPerCourse){
        boolean trainerAlreadyAdded = trainerIsAlreadyInCourse(trainer, course, listOfTrainersPerCourse);
        if (trainerAlreadyAdded) {
            System.out.printf("Trainer %s %s is already assigned to course %s/%s/%s!%n", trainer.getFirstName(), trainer.getLastName(), course.getTitle(), course.getStream(), course.getType());
            return listOfTrainersPerCourse;
        }
        
        if (listOfTrainersPerCourse.isEmpty()){                
            CourseTrainers trainersPerCourse = addTrainerToNewCourse(course, trainer);
            listOfTrainersPerCourse.add(trainersPerCourse);
            System.out.printf("Trainer %s %s successfully added to course %s/%s/%s!%n", trainer.getFirstName(), trainer.getLastName(), course.getTitle(), course.getStream(), course.getType());
            return listOfTrainersPerCourse;
        }
        
        int courseIndexInList = getCourseTrainersIndexInList(course, listOfTrainersPerCourse);
        if (courseIndexInList > -1){
            listOfTrainersPerCourse.get(courseIndexInList).addToLisT(trainer);
        }
        else {
            CourseTrainers trainersPerCourse = addTrainerToNewCourse(course, trainer);
            listOfTrainersPerCourse.add(trainersPerCourse);
        }
        System.out.printf("Trainer %s %s successfully added to course %s/%s/%s!%n", trainer.getFirstName(), trainer.getLastName(), course.getTitle(), course.getStream(), course.getType());                
        return listOfTrainersPerCourse;
    }
    
//    private void addToCourseTrainerList(CourseTrainers courseTrainers){
//        // Lazy-instantiate the list
//        if (listOfCourseTrainers == null){
//            listOfCourseTrainers = new ArrayList();
//        }
//        listOfCourseTrainers.add(courseTrainers);
//    }
    
    /* Returns the index of the CourseTrainer object which has the specified course,
       or returns -1 if it is not found */
    private int getCourseTrainersIndexInList(Course course, List<CourseTrainers> listOfTrainersPerCourse){
        for (int i = 0; i < listOfTrainersPerCourse.size(); i++){
            /* If there is already a courseTrainers object in the list with the 
               specified course, just addToLisT trainers */
            if (listOfTrainersPerCourse.get(i).getCourse().equals(course)){
                //listOfCourseTrainers.get(i).addToLisT(trainer);
                return i;
            }
        }
        return -1;
    }
    
    private boolean trainerIsAlreadyInCourse(Trainer trainer, Course course, List<CourseTrainers> listOfTrainersPerCourse){
        for (CourseTrainers item : listOfTrainersPerCourse){
            if (item.getList().contains(trainer) && item.getCourse().equals(course)){
                //choice = "N";
                return true;
            }
        }
        return false;
    }
    
    private CourseTrainers addTrainerToNewCourse(Course course, Trainer trainer){
        CourseTrainers trainersPerCourse = new CourseTrainers(course);
        trainersPerCourse.addToLisT(trainer);
        return trainersPerCourse;
    }
}
