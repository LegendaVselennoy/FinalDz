package com.example.repository;

import com.example.model.ModelDuck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelDuckRepository extends JpaRepository<ModelDuck,Long> {
}
