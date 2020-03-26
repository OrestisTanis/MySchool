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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orestis
 */
public class UserData {
    private List<Course> courses = new ArrayList();
    private List<Trainer> trainers = new ArrayList();
    private List<Student> students = new ArrayList();
    private List<Assignment> assignments = new ArrayList();
    private List<CourseTrainers> listOfCourseTrainers = new ArrayList();
    private List<CourseStudents> listOfCourseStudents = new ArrayList();
    private List<CourseAssignments> listOfCourseAssignments = new ArrayList();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<CourseTrainers> getListOfCourseTrainers() {
        return listOfCourseTrainers;
    }

    public void setListOfCourseTrainers(List<CourseTrainers> listOfCourseTrainers) {
        this.listOfCourseTrainers = listOfCourseTrainers;
    }

    public List<CourseStudents> getListOfCourseStudents() {
        return listOfCourseStudents;
    }

    public void setListOfCourseStudents(List<CourseStudents> listOfCourseStudents) {
        this.listOfCourseStudents = listOfCourseStudents;
    }

    public List<CourseAssignments> getListOfCourseAssignments() {
        return listOfCourseAssignments;
    }

    public void setListOfCourseAssignments(List<CourseAssignments> listOfCourseAssignments) {
        this.listOfCourseAssignments = listOfCourseAssignments;
    }
    
    
}
