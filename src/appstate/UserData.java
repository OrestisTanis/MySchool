package appstate;

import main.*;
import bootcamp.core.Assignment;
import bootcamp.core.Course;
import bootcamp.core.Student;
import bootcamp.core.Trainer;
import bootcamp.lists.CourseAssignments;
import bootcamp.lists.CourseStudents;
import bootcamp.lists.CourseTrainers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author orestis
 */
public class UserData {
    private Set<Course> setOfCourses;
    private Set<Trainer> setOfTrainers;
    private Set<Student> setOfStudents;
    private Set<Assignment> setOfAssignments;
    private Set<CourseTrainers> setOfTrainersPerCourse;
    private Set<CourseStudents> setOfStudentsPerCourse;
    private Set<CourseAssignments> setOfAssignmentsPerCourse;
    
    public UserData(){
        setOfCourses = new HashSet();
        setOfTrainers = new HashSet();
        setOfStudents = new HashSet();
        setOfAssignments = new HashSet();
        setOfTrainersPerCourse = new HashSet();
        setOfStudentsPerCourse = new HashSet();
        setOfAssignmentsPerCourse = new HashSet();
    }

    public Set<Course> getSetOfCourses() {
        return setOfCourses;
    }

    public Set<Trainer> getSetOfTrainers() {
        return setOfTrainers;
    }

    public Set<Student> getSetOfStudents() {
        return setOfStudents;
    }

    public Set<Assignment> getSetOfAssignments() {
        return setOfAssignments;
    }

    public Set<CourseTrainers> getSetOfTrainersPerCourse() {
        return setOfTrainersPerCourse;
    }

    public Set<CourseStudents> getSetOfStudentsPerCourse() {
        return setOfStudentsPerCourse;
    }

    public Set<CourseAssignments> getSetOfAssignmentsPerCourse() {
        return setOfAssignmentsPerCourse;
    }
}
