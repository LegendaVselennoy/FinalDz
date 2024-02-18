package com.example.controller;

import com.example.model.MallardDuck;
import com.example.model.ModelDuck;
import com.example.model.strategy.FlyRocketPowered;
import com.example.repository.ModelDuckRepository;
import com.example.service.FileGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/modelDuck")
public class ModelDuckController {

    private final ModelDuckRepository duckRepo;
    private final FileGateway fileGateway;

    @GetMapping
    public List<ModelDuck> findAll(){
        return duckRepo.findAll();
    }

    @PostMapping
    public ModelDuck addDuck(@RequestBody ModelDuck duck){
        duck.performFly();
        duck.setFlyBehavior(new FlyRocketPowered());
        fileGateway.writeToFile(duck.getName()+".txt", duck.toString());
        return duckRepo.save(duck);
    }
}
