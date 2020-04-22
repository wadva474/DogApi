package com.wadud.dogapi.service;

import com.wadud.dogapi.entity.Dog;
import com.wadud.dogapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DogServiceImpl implements DogService {
    private DogRepository dogRepository;

    @Autowired
    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }


    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        return optionalBreed.orElseThrow(DogNotFoundException::new);
    }

    @Override
    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllName();
    }
}