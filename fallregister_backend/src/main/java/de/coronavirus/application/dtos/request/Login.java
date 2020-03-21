package de.coronavirus.application.dtos.request;

import de.coronavirus.domain.model.User;

public class Login {
    private User user;

    public Login(User user) {
        this.user = user;
    }
}
