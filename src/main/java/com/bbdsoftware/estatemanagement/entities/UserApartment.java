package com.bbdsoftware.estatemanagement.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UserApartments")
public class UserApartment {

  @Id
  private long userApartmentsId;

  @ManyToOne
  @JoinColumn(name = "UnitNumber")
  private Apartment apartment;

  @ManyToOne
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
