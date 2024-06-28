package com.ages.doacaobackend.business.dto.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRequest {

    @NotNull(message = "Login não pode ser nulo")
    @NotBlank(message = "Login não pode estar em branco")
    private String login;

    @NotNull(message = "Password não pode ser nulo")
    @NotBlank(message = "Password não pode estar em branco")
    private String password;

    public UserRequest(){}

    public UserRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public UserRequest withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserRequest withPassword(String password) {
        this.password = password;
        return this;
    }
}
