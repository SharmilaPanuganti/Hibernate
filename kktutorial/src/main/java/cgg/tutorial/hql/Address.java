package cgg.tutorial.hql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "student_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;
    public int getAddress_id() {
        return address_id;
    }
    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
    private long pincode;
    private String street_name;
    private String city;
    @OneToOne(mappedBy = "address")
    private Student student;
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Address(long pincode, String street_name, String city) {
        this.pincode = pincode;
        this.street_name = street_name;
        this.city = city;
    }
    public Address() {
    }
    public long getPincode() {
        return pincode;
    }
    public void setPincode(long pincode) {
        this.pincode = pincode;
    }
    public String getStreet_name() {
        return street_name;
    }
    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "Address [pincode=" + pincode + ", street_name=" + street_name + ", city=" + city + "]";
    }
}
