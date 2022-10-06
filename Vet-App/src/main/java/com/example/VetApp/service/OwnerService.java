package com.example.VetApp.service;

import com.example.VetApp.entity.Owner;
import com.example.VetApp.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

    public List<Owner> getAllOwner(){
        List<Owner> owner_list = (List<Owner>) repository.findAll();
        return  owner_list;
    }

    public  Owner get(long id){
        return  repository.findById(id).get();
    }

   /* Filtreleme işlemi için*/
   public List<Owner> getByKeyword(String keyword) {
        return repository.findByKeyword(keyword);
    }

    public  void save(Owner owner){
        repository.save(owner);
    }

    public  void delete(long id){
        repository.deleteById(id);
    }
}
