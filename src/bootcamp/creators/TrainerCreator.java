/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.creators;

import bootcamp.core.Trainer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.Input;

/**
 *
 * @author orestis
 */
public class TrainerCreator extends Creator {
    /* Fields */
//    private static List<Trainer> listOfTrainers;
    
    /* Constructor */
    public TrainerCreator() {
    }

    /* Properties */
//    public List<Trainer> getTrainers() {
//        return listOfTrainers;
//    }

    /* Methods */
    public List<Trainer> createTrainers(List<Trainer> listOfTrainers) {
        String choice = "Y";
        while (choice.equalsIgnoreCase("Y")) {
            String firstName = getFirstNameFromUser(nameRegex, nameInvalidMsg);
            String lastName = getLastNameFromUser(nameRegex, nameInvalidMsg);
            String subject = getSubjectFromUser(nameRegex, nameInvalidMsg);
            Trainer trainer = new Trainer(firstName, lastName, subject);
            addTrainerToList(trainer, listOfTrainers);
            System.out.println("\nDo you want to create another Trainer? (Y/N)");
            choice = Input.getString("[yYnN]", "Y/N?");
        }
        return listOfTrainers;
    }
    private String getFirstNameFromUser(String nameRegex, String nameInvalidMsg){
        System.out.println("\nPlease enter trainer first name:");
        return Input.getString(nameRegex, nameInvalidMsg);
    }
    private String getLastNameFromUser(String nameRegex, String nameInvalidMsg){
        System.out.println("\nPlease enter trainer last name:");
        return Input.getString(nameRegex, nameInvalidMsg);
    }
    private String getSubjectFromUser(String nameRegex, String nameInvalidMsg){
        System.out.println("\nPlease enter trainer subject:");
        return Input.getString(nameRegex, nameInvalidMsg);           
    }
    private void addTrainerToList(Trainer trainer, List<Trainer> listOfTrainers){
        boolean trainerAlreadyCreated = trainerExistsInList(trainer, listOfTrainers);
        if (trainerAlreadyCreated){
            String inputInvalidStr = "Trainer %s %s with subject %s already exists!%n";
            System.out.printf(inputInvalidStr, trainer.getFirstName(), trainer.getLastName(), trainer.getSubject());
        }
        else {
            listOfTrainers.add(trainer);
            System.out.printf("\nTrainer %s %s successfuly created!", trainer.getFirstName(), trainer.getLastName());
        }
    }
    private boolean trainerExistsInList(Trainer trainer, List<Trainer> listOfTrainers){
        boolean result = false;
        for (Trainer item: listOfTrainers){
            if (item.equals(trainer)){
                result = true;
            }
        }
        return result;
    }
    
}
