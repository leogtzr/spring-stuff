package com.reactive.playing.reactorplaying.domain;

public class Credentials {

    private String email;
    private String password;

    public Credentials(final String email, final String password) {
        this.email = email;
        this.password = password;
    }

    public Credentials() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
