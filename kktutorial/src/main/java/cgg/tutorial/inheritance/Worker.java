package cgg.tutorial.inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
// @DiscriminatorValue("worker_type")
public class Worker extends Person{
    private String designation;
    private String dept_name;
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getDept_name() {
        return dept_name;
    }
    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
    @Override
    public String toString() {
        return "Worker [designation=" + designation + ", dept_name=" + dept_name + "]" +super.toString();
    }
}
