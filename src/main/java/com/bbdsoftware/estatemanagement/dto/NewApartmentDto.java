package com.bbdsoftware.estatemanagement.dto;

import jakarta.validation.constraints.NotNull;

public class NewApartmentDto {

    @NotNull(message = "UnitNumber field is required")
    private Long unitNumber;

    @NotNull(message = "Bedrooms field is required")
    private Long bedrooms;

    @NotNull(message = "Bathrooms field is required")
    private Long bathrooms;

    @NotNull(message = "parkingSpaces field is required")
    private Long parkingSpaces;

    public long getBedrooms() {
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
