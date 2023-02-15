package com.bbdsoftware.estatemanagement.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "apartments")
public class Apartment {

  @Id
  private long unitNumber;

  @ManyToOne
  @JoinColumn(name = "ApartmentDetailsID")
  private ApartmentDetails details;


  public long getUnitNumber() {
    return unitNumber;
  }

  public void setUnitNumber(long unitNumber) {
    this.unitNumber = unitNumber;
  }

  public ApartmentDetails getDetails() {
    return details;
  }

  public void setDetails(ApartmentDetails details) {
    this.details = details;
  }
}
