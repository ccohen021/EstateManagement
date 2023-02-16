package com.bbdsoftware.estatemanagement.dto;

import com.bbdsoftware.estatemanagement.entities.User;

import java.sql.Date;
import java.util.Objects;

public final class TenantDto {

    private User user;
    private Date movedIn;
    private Date movedOut;

    public User getUser() {
        return user;
    }


    public Date getMovedIn() {
        return movedIn;
    }


    public Date getMovedOut() {
        return movedOut;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public void setMovedIn(Date movedIn) {
        this.movedIn = movedIn;
    }


    public void setMovedOut(Date movedOut) {
        this.movedOut = movedOut;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (TenantDto) obj;
        return Objects.equals(this.user, that.user) &&
                Objects.equals(this.movedIn, that.movedIn) &&
                Objects.equals(this.movedOut, that.movedOut);
    }


    @Override
    public int hashCode() {
        return Objects.hash(user, movedIn, movedOut);
    }


    @Override
    public String toString() {
        return "TenantsDto[" +
                "user=" + user + ", " +
                "movedIn=" + movedIn + ", " +
                "movedOut=" + movedOut + ']';
    }

}
