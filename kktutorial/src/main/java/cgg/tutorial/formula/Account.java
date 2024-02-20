package cgg.tutorial.formula;

import jakarta.persistence.Column;
// import org.hibernate.annotations.DialectOverride.Formula;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.FetchProfiles;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.NaturalId;

@Entity
@DynamicInsert
@Table(
  uniqueConstraints = @UniqueConstraint(
    columnNames = "email",
    name = "uk_email"
  ),
  indexes = @Index(columnList = "fname,lName", name = "idx_acc_name")
)
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ColumnDefault(value = "5")
  private Double rate;

  private Double credit;

  @Formula(value = "credit *rate")
  private Double interest;

  @NaturalId(mutable = true)
  private String isbn;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  private String email;
  private String fname;

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  private String lName;

  public String getlName() {
    return lName;
  }

  public void setlName(String lName) {
    this.lName = lName;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Account() {}

  public Account(Double rate, Double credit, Double interest) {
    this.rate = rate;
    this.credit = credit;
    this.interest = interest;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Double getRate() {
    return rate;
  }

  public void setRate(Double rate) {
    this.rate = rate;
  }

  public Double getCredit() {
    return credit;
  }

  public void setCredit(Double credit) {
    this.credit = credit;
  }

  public Double getInterest() {
    return interest;
  }

  public void setInterest(Double interest) {
    this.interest = interest;
  }

  @Override
  public String toString() {
    return (
      "Account [id=" +
      id +
      ", rate=" +
      rate +
      ", credit=" +
      credit +
      ", interest=" +
      interest +
      "]"
    );
  }
}
