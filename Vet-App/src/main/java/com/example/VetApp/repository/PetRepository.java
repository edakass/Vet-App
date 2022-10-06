package com.example.VetApp.repository;

import com.example.VetApp.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
    /*
     @Query(value = "SELECT * FROM USERS WHERE LASTNAME = ?1",
    countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1",
    nativeQuery = true)

    @Query("select u from User u where u.lastname like %:#{[0]}% and u.lastname like %:lastname%")
     */
    @Query(value = "select * from pet p where (p.pet_name, p.pet_age ) like %:keyword%", nativeQuery = true)
    List<Pet> findByKeyword(@Param("keyword") String keyword);
}
