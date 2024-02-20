package cgg.hibernate.map1;

import java.util.List;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Emp {
    @Id
    private int emp_id;
    private String name;
    @ManyToMany

    @JoinTable(name = "emp_proj", joinColumns = { @JoinColumn(name = "e_id") }, inverseJoinColumns = {
            @JoinColumn(name = "p_id") })
    // @CollectionId(column = @Column(name="proj_id",columnDefinition ="int" ),generator = "")
    // @JdbcTypeCode(java.sql.)
    private List<Project> projects;

    public Emp(int emp_id, String name, List<Project> projects) {
        this.emp_id = emp_id;
        this.name = name;
        this.projects = projects;
    }

    public Emp() {
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Emp [emp_id=" + emp_id + ", name=" + name + ", projects=" + projects + "]";
    }
}
