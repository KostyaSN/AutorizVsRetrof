package com.test.autorizvsretrof;

/**
 * Created by kostyasnetko on 29.03.16.
 */
public class UserBase {
    @Override
    public String toString() {
        return "UserBase{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", nikname='" + nikname + '\'' +
                ", userpass='" + userpass + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNikname() {
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    private String name;
    private String password;
    private String nikname;
    private String userpass;
}
