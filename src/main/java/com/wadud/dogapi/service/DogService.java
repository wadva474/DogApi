package com.wadud.dogapi.service;


import com.wadud.dogapi.entity.Dog;

import java.util.List;


public interface DogService {
    List<Dog> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
}
