package model;

public class LoginSignupResponse {
    private boolean success;
    private String status;
    private String message, username, userImage, phoneNumber, email, full_name;
    private int user_id;
    private String token,role;

    public String getRole() {
        return role;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getUserImage() {
        return userImage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getFull_name() {
        return full_name;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
