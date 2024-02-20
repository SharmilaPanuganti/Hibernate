package cgg.tutorial.nativeCollections;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="phone_numbers")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
 private Long id;
@ManyToOne
@JoinColumn(name="person_id")
 private Person2 person;
 private String number;
 @OneToMany(mappedBy = "phone",cascade = CascadeType.ALL,orphanRemoval = true)
 private List<Call> calls=new ArrayList<>();
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public Person2 getPerson() {
    return person;
}
public void setPerson(Person2 person) {
    this.person = person;
}
public String getNumber() {
    return number;
}
public void setNumber(String number) {
    this.number = number;
}
public List<Call> getCalls() {
    return calls;
}
public void setCalls(List<Call> calls) {
    this.calls = calls;
}
@Override
public String toString() {
    return "Phone [id=" + id +"=" + number + "]";
}

}
