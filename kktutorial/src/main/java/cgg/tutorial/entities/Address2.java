package cgg.tutorial.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address_table")
public class Address2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;
  private String street;
  private String city;
  private String state;
  private Long pincode;
public Address2() {
    
}
public Address2(String street, String city, String state, Long pincode) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.pincode = pincode;
}
public String getStreet() {
    return street;
}
public void setStreet(String street) {
    this.street = street;
}
public String getCity() {
    return city;
}
public void setCity(String city) {
    this.city = city;
}
public String getState() {
    return state;
}
public void setState(String state) {
    this.state = state;
}
public Long getPincode() {
    return pincode;
}
public void setPincode(Long pincode) {
    this.pincode = pincode;
}
@Override
public String toString() {
    return "Address [street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
}
}

