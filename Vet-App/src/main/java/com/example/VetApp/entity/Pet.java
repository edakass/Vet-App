package com.example.VetApp.entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
//import org.hibernate.annotations.Entity;

@Entity
@Table(name="pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Nullable
    private String petType;

    @Nullable
    private String petBreed;

    @Nullable
    private String petName;

    @Nullable
    private int petAge;

    @Nullable
    private  String petDescription;

    public  Pet(){

    }

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable=false)
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Pet(Long id, String petType, String petBreed, String petName, int petAge, String petDescription) {
        this.id = id;
        this.petType = petType;
        this.petBreed = petBreed;
        this.petName = petName;
        this.petAge = petAge;
        this.petDescription = petDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", petType='" + petType + '\'' +
                ", petBreed='" + petBreed + '\'' +
                ", petName='" + petName + '\'' +
                ", petAge=" + petAge +
                ", petDescription='" + petDescription + '\'' +
                '}';
    }
}
