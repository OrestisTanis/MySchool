/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.lists;

import bootcamp.core.Course;
import bootcamp.core.Trainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.Input;

/**
 *
 * @author orestis
 */
public class CourseTrainers extends CourseList<Trainer> {
    
    /* Constructors */
    public CourseTrainers(Course course){
        super(course);
    }
    
    public CourseTrainers(Course course, List<Trainer> list){
        super(course, list);
    }
    
     @Override
    public String toString() {
        return String.format("%s Trainers: %s", getCourse(), getList());
    }
    
    
}
