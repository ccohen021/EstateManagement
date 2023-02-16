package com.bbdsoftware.estatemanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "apartments")
public class Apartment {

  @Id
  @NotNull
  private long unitNumber;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ApartmentDetailsID")
  @NotNull
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
