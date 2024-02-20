package cgg.tutorial.inheritance;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
// @DiscriminatorValue("student")
public class Pupil extends Person{
    private Date dob;
    private String school_name;
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getSchool_name() {
        return school_name;
    }
    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }
    @Override
    public String toString() {
        return "Pupil [dob=" + dob + ", school_name=" + school_name + "]" +super.toString();
    }
}
