package cgg.hibernate;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;

@Entity
@DynamicUpdate
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name = "Student.byId",query = "from Student where id=:i")
@NamedNativeQuery(name="Student.byName",query = "select * from student where name=:n",resultClass = Student.class)
public class Student {
   
    @Id
    private int id;
    private String name;
    private String city;
    private Certificate certificate;
    public Student(int id, String name, String city, Certificate certificate) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.certificate = certificate;
    }
    public Certificate getCertificate() {
        return certificate;
    }
    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    public Student() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", city=" + city + ", certificate=" + certificate + "]";
    }
    
}
