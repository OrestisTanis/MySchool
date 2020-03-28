/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.core;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author orestis
 */
public class Course {
    /* Fields */
    private String title;
    private String stream;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;
    
    /* Constructor */
    
    public Course(String title, String stream, String type){
        this.title = title;
        this.stream = stream;
        this.type = type;
    }

    public Course(String title, String stream, String type, LocalDate start_date, LocalDate end_date) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    
    /* Accessor Properties */
    public String getTitle(){
        return title;
    }    
    public void setTitle(String title){
        this.title = title;
    }    
    
    public String getStream(){
        return stream;
    }    
    public void setStream(String stream){
        this.stream = stream;
    }
    
    public String getType(){
        return type;
    }    
    public void setType(String type){
        this.type = type;
    }
    
    public LocalDate getStartDate(){
        return start_date;
    }    
    public void setStartDate(LocalDate start_date){
        this.start_date = start_date;
    }
    
    public LocalDate getEndDate(){
        return end_date;
    }    
    public void setEndDate(LocalDate end_date){
        this.end_date = end_date;
    }

    /* Methods */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.title);
        hash = 61 * hash + Objects.hashCode(this.stream);
        hash = 61 * hash + Objects.hashCode(this.type);
        hash = 61 * hash + Objects.hashCode(this.start_date);
        hash = 61 * hash + Objects.hashCode(this.end_date);
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.stream, other.stream)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.start_date, other.start_date)) {
            return false;
        }
        if (!Objects.equals(this.end_date, other.end_date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title + ", stream: " + stream + ", type:  " + type + ", Start. date: " + start_date + ", End date: " + end_date;
    }

    
    
}
