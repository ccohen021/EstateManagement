package com.bbdsoftware.estatemanagement.entities;

import jakarta.persistence.*;

@Entity
public class ApartmentDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long apartmentDetailsID;
  private long bedrooms;
  private long bathrooms;
  private long parkingSpaces;

  public long getApartmentDetailsID() {
    return apartmentDetailsID;
  }

  public void setApartmentDetailsID(long sizeId) {
    this.apartmentDetailsID = sizeId;
  }


  public long getBedrooms() {
    return bedrooms;
  }

  public void setBedrooms(long bedrooms) {
    this.bedrooms = bedrooms;
  }


  public long getBathrooms() {
    return bathrooms;
  }

  public void setBathrooms(long bathrooms) {
    this.bathrooms = bathrooms;
  }


  public long getParkingSpaces() {
    return parkingSpaces;
  }

  public void setParkingSpaces(long parkingSpaces) {
    this.parkingSpaces = parkingSpaces;
  }

}
