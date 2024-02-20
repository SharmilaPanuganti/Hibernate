package cgg.tutorial.nativeCollections;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "phone_call")
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "phone_id")
  private Phone phone;
  private Date date;
public Call() {
}
public Call(Long id, Phone phone, Date date) {
    this.id = id;
    this.phone = phone;
    this.date = date;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public Phone getPhone() {
    return phone;
}
public void setPhone(Phone phone) {
    this.phone = phone;
}
public Date getDate() {
    return date;
}
public void setDate(Date date) {
    this.date = date;
}
@Override
public String toString() {
    return "Call [id=" + id  + ", date=" + date + "]";
}
}
