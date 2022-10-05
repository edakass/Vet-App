package com.example.VetApp.repository;

import com.example.VetApp.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {
    @Query(value = "select * from owner o where o.full_name like %:keyword%", nativeQuery = true)
    List<Owner> findByKeyword(@Param("keyword") String keyword);
}
