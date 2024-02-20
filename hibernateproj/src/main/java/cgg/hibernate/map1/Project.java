package cgg.hibernate.map1;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Project {
    @Id
 private int project_id;
 private String project_name;
 @ManyToMany(mappedBy = "projects")
 private List<Emp> emplooyees;
public Project() {
}
public Project(int project_id, String project_name, List<Emp> emplooyees) {
    this.project_id = project_id;
    this.project_name = project_name;
    this.emplooyees = emplooyees;
}
public int getProject_id() {
    return project_id;
}
public void setProject_id(int project_id) {
    this.project_id = project_id;
}
public String getProject_name() {
    return project_name;
}
public void setProject_name(String project_name) {
    this.project_name = project_name;
}
public List<Emp> getEmplooyees() {
    return emplooyees;
}
public void setEmplooyees(List<Emp> emplooyees) {
    this.emplooyees = emplooyees;
}
@Override
public String toString() {
    return "Project [project_id=" + project_id + ", project_name=" + project_name + ", emplooyees=" + emplooyees + "]";
}

}
