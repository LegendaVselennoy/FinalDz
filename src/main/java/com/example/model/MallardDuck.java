package com.example.model;

import com.example.model.strategy.FlyRocketPowered;
import com.example.model.strategy.FlyWithWings;
import com.example.model.strategy.Quack;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MallardDuck extends Duck{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public MallardDuck() {
        quackBehavior=new Quack();
        flyBehavior=new FlyWithWings();
    }
}
