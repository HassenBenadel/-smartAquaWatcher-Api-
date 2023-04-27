package com.example.projectapi.Repository;

import com.example.projectapi.Entity.Grandeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrandeurRepository extends JpaRepository<Grandeur,Long> {

    Grandeur findFirstByOrderByIdDesc();



}
