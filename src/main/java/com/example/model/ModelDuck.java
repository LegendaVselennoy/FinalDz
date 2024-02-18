package com.example.model;

import com.example.model.strategy.FlyNoWay;
import com.example.model.strategy.FlyRocketPowered;
import com.example.model.strategy.Quack;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ModelDuck extends Duck{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public ModelDuck(){
        flyBehavior=new FlyNoWay();
        quackBehavior=new Quack();
        setFlyBehavior(new FlyRocketPowered());
    }
}
