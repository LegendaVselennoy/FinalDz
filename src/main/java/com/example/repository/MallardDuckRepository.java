package com.example.repository;

import com.example.model.MallardDuck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MallardDuckRepository extends JpaRepository<MallardDuck,Long> {
}
