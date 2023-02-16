package com.bbdsoftware.estatemanagement.dto;

import jakarta.validation.constraints.NotNull;

public class PartialApartmentDto {

    @NotNull(message = "UnitNumber field is required")
    private Long unitNumber;

    private Long bedrooms;

    private Long bathrooms;

    private Long parkingSpaces;

    public Long getBedrooms() {
        return bedrooms;
    }


    public void setBedrooms(Long bedrooms) {
        this.bedrooms = bedrooms;
    }


    public Long getBathrooms() {
        return bathrooms;
    }


    public void setBathrooms(Long bathrooms) {
        this.bathrooms = bathrooms;
    }


    public Long getParkingSpaces() {
        return parkingSpaces;
    }


    public void setParkingSpaces(Long parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }


    public long getUnitNumber() {
        return unitNumber;
    }


    public void setUnitNumber(Long unitNumber) {
        this.unitNumber = unitNumber;
    }


    @Override
    public String toString() {
        return "NewApartmentDto{" +
                "unitNumber=" + unitNumber +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", parkingSpaces=" + parkingSpaces +
                '}';
    }
}
