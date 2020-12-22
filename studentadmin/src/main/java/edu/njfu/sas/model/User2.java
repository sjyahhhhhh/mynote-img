package edu.njfu.sas.model;

public class User2 {
    private String username;
    private String password;
    private String stuno;
    private int id;
    private int type;

    public User2(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User2(int id, String username, String password, int type, String stuno) {
        this.username = username;
        this.password = password;
        this.stuno = stuno;
        this.id = id;
        this.type = type;
    }

    public User2() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStuno() {
        return stuno;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", stuno='" + stuno + '\'' +
                ", id=" + id +
                ", type=" + type +
                '}';
    }

}
