package de.coronavirus.application.dtos.request;

public class RefreshSession {
    Token sessionToken;

    public RefreshSession(Token sessionToken) {
        this.sessionToken = sessionToken;
    }
}
