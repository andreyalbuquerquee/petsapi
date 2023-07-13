package br.com.tech4me.petsapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.petsapi.models.Pet;

public interface PetRepository extends MongoRepository<Pet, String> {
    
}
