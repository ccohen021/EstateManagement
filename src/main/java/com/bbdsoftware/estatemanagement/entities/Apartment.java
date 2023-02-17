package com.bbdsoftware.estatemanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "apartments")
public class Apartment {

    @Id
    @NotNull
    private long unitNumber;

    private long bedrooms;
    private long bathrooms;
    private long parkingSpaces;


    public long getUnitNumber() {
      return unitNumber;
    }


    public void setUnitNumber(long unitNumber) {
      this.unitNumber = unitNumber;
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
