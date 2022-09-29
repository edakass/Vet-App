package com.example.VetApp.controller.dto;

public class UserRegistrationDto {
    private String fullName;

    private String email;

    private String password;

    private String telNumber;

    private String contactInformation;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String fullName, String email, String password, String telNumber, String contactInformation) {
        super();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.telNumber = telNumber;
        this.contactInformation = contactInformation;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
