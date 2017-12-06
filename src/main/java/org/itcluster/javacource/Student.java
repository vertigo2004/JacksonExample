package org.itcluster.javacource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private double averageScore;
//    @JsonIgnore
    private String notes;

    public Student() {
    }

    public Student(String firstname, String lastname, LocalDate dob, double averageScore, String notes) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.averageScore = averageScore;
        this.notes = notes;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dob=" + dob +
                ", averageScore=" + averageScore +
                ", notes='" + notes + '\'' +
                '}';
    }
}
