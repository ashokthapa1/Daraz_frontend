package model;

public class Users {
    private String full_name, username, email, phoneNumber, password, userImage, userPostImage;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(String full_name, String username, String email, String phoneNumber, String password, String userImage) {
        this.full_name = full_name;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userImage = userImage;
    }

    public Users(String userPostImage) {
        this.userPostImage = userPostImage;
    }

    public String getUserPostImage() {
        return userPostImage;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
