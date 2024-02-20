package cgg.tutorial.hql;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "student_backup")
public class BackupStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int student_id;
    private String name;
    @Column(name = "date_of_birth")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dob;
    private double marks;
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public BackupStudent(int student_id, String name, Date dob, double marks) {
        this.student_id = student_id;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    public BackupStudent() {
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
        return "BackupStudent [student_id=" + student_id + ", name=" + name + ", dob=" + dob + ", marks=" + marks;
    }

}
