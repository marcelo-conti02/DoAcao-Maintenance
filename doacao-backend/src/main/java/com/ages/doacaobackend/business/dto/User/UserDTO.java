package com.ages.doacaobackend.business.dto.User;

public class UserDTO {
    private int id;

    private boolean isadmin;

    public UserDTO(int id, boolean isadmin) {
        this.id = id;
        this.isadmin = isadmin;
    }

    public UserDTO() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsadmin() {
        return this.isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public UserDTO withId(int id) {
        this.id = id;
        return this;
    }

    public UserDTO withIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
        return this;
    }
}
