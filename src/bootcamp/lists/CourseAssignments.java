/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.lists;

import bootcamp.core.Assignment;
import bootcamp.core.Course;
import java.util.List;

/**
 *
 * @author orestis
 */
public class CourseAssignments extends CourseList<Assignment> {
    
    /* Constructors */
    public CourseAssignments(Course course){
        super(course);
    }
    
    public CourseAssignments(Course course, List<Assignment> list){
        super(course, list);
    }
    
}