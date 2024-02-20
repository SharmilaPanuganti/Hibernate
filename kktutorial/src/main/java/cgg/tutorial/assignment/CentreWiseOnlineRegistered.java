package cgg.tutorial.assignment;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "center_wise_online_registered", schema = "public")
public class CentreWiseOnlineRegistered {

  @Column(name = "date")
  private Date date;

  @Id
  @Column(name = "center_id")
  private Integer centerId;

  @Column(name = "capacity")
  private Integer capacity;

  @Column(name = "registered_students")
  private Integer registeredStudents;

  @Column(name = "status", length = 20)
  private String status;

  @Column(name = "inserted_time")
  private Date insertedTime;

  @Column(name = "passid")
  private Integer passid;

  @Column(name = "map_id")
  private Integer mapId;

  // Constructors

  public CentreWiseOnlineRegistered() {
    // Default constructor
  }

  public CentreWiseOnlineRegistered(
    Date date,
    Integer centerId,
    Integer capacity,
    Integer registeredStudents,
    String status,
    Date insertedTime,
    Integer passid,
    Integer mapId
  ) {
    this.date = date;
    this.centerId = centerId;
    this.capacity = capacity;
    this.registeredStudents = registeredStudents;
    this.status = status;
    this.insertedTime = insertedTime;
    this.passid = passid;
    this.mapId = mapId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Integer getCenterId() {
    return centerId;
  }

  public void setCenterId(Integer centerId) {
    this.centerId = centerId;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public Integer getRegisteredStudents() {
    return registeredStudents;
  }

  public void setRegisteredStudents(Integer registeredStudents) {
    this.registeredStudents = registeredStudents;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getInsertedTime() {
    return insertedTime;
  }

  public void setInsertedTime(Date insertedTime) {
    this.insertedTime = insertedTime;
  }

  public Integer getPassid() {
    return passid;
  }

  public void setPassid(Integer passid) {
    this.passid = passid;
  }

  public Integer getMapId() {
    return mapId;
  }

  public void setMapId(Integer mapId) {
    this.mapId = mapId;
  }
}
