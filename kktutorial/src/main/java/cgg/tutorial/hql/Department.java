package cgg.tutorial.hql;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.FetchProfile.FetchOverride;
import org.hibernate.annotations.FetchProfiles;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@FetchProfiles(value = {
        @FetchProfile(fetchOverrides = {
                @FetchOverride(association = "students", entity = Department.class, mode = FetchMode.JOIN),
        }, name = "dept.students"),
})
// @NamedEntityGraph(name = "dept.students", attributeNodes =
// @NamedAttributeNode("students"))
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dept_id;

    private String dept_name;

    // @Immutable - to make the collection immutable
    // @BatchSize(size = 2)
    // @Fetch(value = FetchMode.SELECT)
    // @Fetch(value = FetchMode.SUBSELECT)
    // @Fetch(value = FetchMode.JOIN)
    // @LazyCollection(value = LazyCollectionOption.EXTRA)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Set<BackupStudent> students = new HashSet<BackupStudent>();

    public Department() {
    }

    public Department(
            int dept_id,
            String dept_name,
            Set<BackupStudent> students) {
        this.dept_id = dept_id;
        this.dept_name = dept_name;
        this.students = students;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public Set<BackupStudent> getStudents() {
        return students;
    }

    public void setStudents(Set<BackupStudent> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + "]";
    }
}
