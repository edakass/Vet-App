package com.example.VetApp.service;

import com.example.VetApp.entity.Pet;
import com.example.VetApp.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetService {
    @Autowired
    private PetRepository repository;

    public List<Pet> getAllPet(){
        List<Pet> pet_list = (List<Pet>)repository.findAll();
        return pet_list;
    }

    public Pet get(int id){
        return  repository.findById(id).get();
    }

    public List<Pet> getByKeyword(String keyword) {
        return repository.findByKeyword(keyword);
    }

    public void save(Pet pet) {
        repository.save(pet);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
