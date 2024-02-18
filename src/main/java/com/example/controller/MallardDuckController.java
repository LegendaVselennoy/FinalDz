package com.example.controller;

import com.example.model.MallardDuck;
import com.example.repository.MallardDuckRepository;
import com.example.service.FileGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mallardDuck")
public class MallardDuckController {
    private final MallardDuckRepository duckRepo;
    private final FileGateway fileGateway;

    @GetMapping
    public List<MallardDuck>findAll(){
        return duckRepo.findAll();
    }

    @PostMapping
    public MallardDuck addDuck(@RequestBody MallardDuck duck){
        duck.performFly();
        fileGateway.writeToFile(duck.getName()+".txt", duck.performQuack());
        return duckRepo.save(duck);
    }
}
