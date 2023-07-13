package br.com.tech4me.petsapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.petsapi.services.PetService;
import br.com.tech4me.petsapi.shared.PetDto;
import br.com.tech4me.petsapi.shared.PetListDto;

@RestController
@RequestMapping("/pets")
public class PetController {
    
    @Autowired
    private PetService service;

    @GetMapping
    private ResponseEntity<List<PetListDto>> listPets() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PetDto> getPetById(@PathVariable String id) {
        Optional<PetDto> pet = service.getById(id);

        if (pet.isPresent()) {
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<PetDto> addPet(@RequestBody PetDto pet) {
        return new ResponseEntity<>(service.create(pet), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<PetDto> updatePet(@PathVariable String id, @RequestBody PetDto pet) {
        PetDto updatedPet = service.updateById(id, pet);

        if (updatedPet != null) {
            return new ResponseEntity<>(updatedPet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletePetById(@PathVariable String id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
