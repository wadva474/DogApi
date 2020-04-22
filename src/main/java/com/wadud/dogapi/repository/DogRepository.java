package com.wadud.dogapi.repository;

import com.wadud.dogapi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("SELECT d.id,d.breed FROM Dog d WHERE d.id= :id ")
    String findBreedById(Long id);


    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();
}
