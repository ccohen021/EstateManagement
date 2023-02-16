package com.bbdsoftware.estatemanagement.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UserApartments")
public class UserApartment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userApartmentsId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "UnitNumber")
  private Apartment apartment;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "userID")
  private User user;

  private java.sql.Date movedIn;
  private java.sql.Date movedOut;


  public long getUserApartmentsId() {
    return userApartmentsId;
  }

  public void setUserApartmentsId(long userApartmentsId) {
    this.userApartmentsId = userApartmentsId;
  }

  public Apartment getApartment() {
    return apartment;
  }

  public void setApartment(Apartment apartment) {
    this.apartment = apartment;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public java.sql.Date getMovedIn() {
    return movedIn;
  }

  public void setMovedIn(java.sql.Date movedIn) {
    this.movedIn = movedIn;
  }


  public java.sql.Date getMovedOut() {
    return movedOut;
  }

  public void setMovedOut(java.sql.Date movedOut) {
    this.movedOut = movedOut;
  }

}
