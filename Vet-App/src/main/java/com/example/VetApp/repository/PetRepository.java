package com.example.VetApp.repository;

import com.example.VetApp.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {
    List<Pet> findByUserId(long id);
    @Query(value = "select * from pet p where p.pet_name like %:keyword%", nativeQuery = true)
    List<Pet> findByKeyword(@Param("keyword") String keyword);
}
