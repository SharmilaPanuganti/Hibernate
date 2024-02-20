package cgg.tutorial.entities;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_table")
@DynamicUpdate
public class Employee {

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empid_gen")
    @SequenceGenerator(name = "empid_gen", initialValue = 1, allocationSize = 1, sequenceName = "empid_seq")
    // @GeneratedValue(strategy = GenerationType.TABLE,generator = "empid_gen")
    // @TableGenerator(name = "empid_gen",initialValue = 1,allocationSize = 2,table
    // = "empid_seq")
    @Column(name = "emp_id")
    private int empId;
    @Column(name = "emp_name", length = 100, nullable = false)
    private String empName;

    @Column(unique = true)
    private String email;
    @Column(name = "date_of_joining")
    private Date doj;
    private double salary;
    // @Embedded
    // @AttributeOverrides(value = {
    // @AttributeOverride(column = @Column(name = "home_street",length = 55), name =
    // "street"),
    // @AttributeOverride(column = @Column(name = "home_city"), name = "city"),
    // @AttributeOverride(column = @Column(name = "home_pincode"), name =
    // "pincode"),
    // @AttributeOverride(column = @Column(name = "home_state"), name = "state")
    // })
    // private Address home_address;
    // private Address ofc_address;
    // @ElementCollection
    // @JoinTable(name = "address_table", joinColumns = @JoinColumn(name = "emp_id"))
    // @GenericGenerator(name = "sequence_gen", strategy = "sequence")
    // @CollectionId(
    //     column = @Column(name = "address_id"),
    //     generator = "sequence_gen",
    //     type = @Type(type = "long")
    // ) 
    // private Collection<Address> addresslist = new HashSet<>();
    // public Address getHome_address() {
    // return home_address;
    // }

    // public void setHome_address(Address home_address) {
    // this.home_address = home_address;
    // }

    // public Address getOfc_address() {
    // return ofc_address;
    // }

    // public void setOfc_address(Address ofc_address) {
    // this.ofc_address = ofc_address;
    // }

    // public Collection<Address> getAddresslist() {
    //     return addresslist;
    // }

    // public void setAddresslist(Collection<Address> addresslist) {
    //     this.addresslist = addresslist;
    // }
    @OneToOne
    private Address2 address;

    public Address2 getAddress() {
        return address;
    }

    public void setAddress(Address2 address) {
        this.address = address;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email + ", doj=" + doj + ", salary="
                + salary + "]";
    }
}
