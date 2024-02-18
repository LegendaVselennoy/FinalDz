package com.example.model.strategy;

public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Я лечу на ракете!");
    }
}
