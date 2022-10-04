package com.example.VetApp.repository;

import com.example.VetApp.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {
    //User findByEmail(String email); doğru mu yapcam
}
