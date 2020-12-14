package com.hillel.artemjev.userparse;


import java.util.Objects;

public class User {

    private String username;
    private String nickname;
    private String passwod;

//    public User(String username) {
//        this.username = username;
//        this.nickname = username;
//    }
//
//    public User(String username, String nickname) {
//        this.username = username;
//        this.nickname = nickname;
//    }

    public User(String username, String nickname, String passwod) {
        this.username = username;
        this.nickname = nickname;
        this.passwod = passwod;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPasswod() {
        return passwod;
    }

    public void setPasswod(String passwod) {
        this.passwod = passwod;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", passwod='" + passwod + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) &&
                nickname.equals(user.nickname) &&
                Objects.equals(passwod, user.passwod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, nickname, passwod);
    }
}
