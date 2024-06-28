package com.ages.doacaobackend.business.dto.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginRequest {

    @NotNull(message = "Login não pode ser nulo")
    @NotBlank(message = "Login não pode estar em branco")
    private String login;

    @NotNull(message = "Password não pode ser nulo")
    @NotBlank(message = "Password não pode estar em branco")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest withLogin(String login) {
        this.login = login;
        return this;
    }

    public LoginRequest withPassword(String password) {
        this.password = password;
        return this;
    }
}
