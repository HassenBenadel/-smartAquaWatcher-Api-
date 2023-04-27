package com.example.projectapi.Repository;

import com.example.projectapi.Entity.Barage;
import com.example.projectapi.Entity.Grandeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarageRepository extends JpaRepository<Barage,Long> {




}
