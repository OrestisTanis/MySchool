/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.lists;

import bootcamp.core.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author orestis
 */
public abstract class CourseList<T>{
    private Course course;
    private List<T> list;
    private String type;
    
    /* Constructors */
    protected CourseList(Course course){
        // Save the data-type of the object that's going to be instantiated
        this.type = getClass().getName();
        this.course = course;
    }
    
    protected CourseList(Course course, List<T> list){
        this(course);
        this.list = list;
    }
    
    /* Properties */
    public List<T> getList(){
        return list;
    }
    
    public Course getCourse(){
        return course;
    }
    
    public String getType() {
        return this.type;
    }
    
    /*  Methods */
    public void addToLisT(T item){
        // Lazy-instantiate the list
        if (list == null){
            list = new ArrayList();
        }
        // Add to list
        this.list.add(item);
    }
    
//    public void printList(){
//        System.out.printf("******* Printing %s list of %s ********\n", course.getTitle(), type.substring(type.lastIndexOf(".") + 7));
//        for (int i = 0; i < list.size(); i++){
//           
//        }
//    }
    
    public boolean listIsEmpty(){
        return list.size() == 0;
    }
    
    public boolean containedInList(T item){
        return list.contains(item);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.course);
        hash = 19 * hash + Objects.hashCode(this.list);
        hash = 19 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CourseList<?> other = (CourseList<?>) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.list, other.list)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "CourseList{" + "course=" + course + ", list=" + list + ", type=" + type + '}';
    }
    
    

   
    
    
}