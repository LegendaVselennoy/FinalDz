package com.example.model;

import com.example.model.strategy.FlyBehavior;
import com.example.model.strategy.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;


    public void performFly(){
        flyBehavior.fly();
    }

    public String performQuack(){
       return  quackBehavior.quack();
    }



    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior=fb;
    }

}
