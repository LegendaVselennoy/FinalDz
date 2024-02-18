package com.example.model.strategy;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Я не летаю");
    }
}
