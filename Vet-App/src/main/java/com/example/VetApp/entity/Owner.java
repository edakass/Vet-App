package com.example.VetApp.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String fullName;

    private String contactInfo;

    private String telNumber;

    private int email;

    @OneToMany(mappedBy="owner")
    private Set<Pet> pets;



    public  Owner(){

    }

    public Owner(String fullName, String contactInfo, String telNumber, int email) {
        this.fullName = fullName;
        this.contactInfo = contactInfo;
        this.telNumber = telNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", email=" + email +
                '}';
    }
}
