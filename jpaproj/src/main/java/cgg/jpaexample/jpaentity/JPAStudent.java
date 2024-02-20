package cgg.jpaexample.jpaentity;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="jpa_student")
public class JPAStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int student_id;
    private String name;
    @Column(name = "date_of_birth")
    private Date dob;
    private double marks;
    
    public JPAStudent(int student_id, String name, Date dob, double marks) {
        this.student_id = student_id;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }
    public JPAStudent() {
    }
    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "BackupStudent [student_id=" + student_id + ", name=" + name + ", dob=" + dob + ", marks=" + marks
                ;
    }
    
}

