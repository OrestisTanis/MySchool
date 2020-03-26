/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.lists;

import bootcamp.core.Course;
import bootcamp.core.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orestis
 */
public class CourseStudents extends CourseList<Student> {
    /* Constructors */
    public CourseStudents(Course course){
        super(course);
    }
    
    public CourseStudents(Course course, List<Student> list){
        super(course, list);
    }
    
    
}
