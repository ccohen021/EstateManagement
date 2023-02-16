package com.bbdsoftware.estatemanagement.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class NewApartmentDto {
    @NotNull
    private long unitNumber;
    @NotNull
    private long bedrooms;
    @NotNull
    private long bathrooms;
    @NotNull
    private long parkingSpaces;

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

    public long getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(long unitNumber) {
        this.unitNumber = unitNumber;
    }
}
