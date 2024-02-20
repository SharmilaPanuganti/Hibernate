package cgg.tutorial.nativeCollections;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
@Entity
@Table(name= "person_mapped")
public class Person2 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int person_id;
  private String name;
  @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
  @OrderColumn(name = "order_id")
  private List<Phone> phones=new ArrayList<>();
public int getPerson_id() {
    return person_id;
}
public void setPerson_id(int person_id) {
    this.person_id = person_id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public List<Phone> getPhones() {
    return phones;
}
public void setPhones(List<Phone> phones) {
    this.phones = phones;
}
}
