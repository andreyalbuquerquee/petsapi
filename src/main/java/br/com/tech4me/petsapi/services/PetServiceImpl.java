package br.com.tech4me.petsapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.petsapi.models.Pet;
import br.com.tech4me.petsapi.repositories.PetRepository;
import br.com.tech4me.petsapi.shared.PetDto;
import br.com.tech4me.petsapi.shared.PetListDto;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepo;

    @Override
    public List<PetListDto> getAll() {
        return petRepo.findAll()
            .stream()
            .map(p -> new PetListDto(p.getId(), p.getName(), p.getProcedures()))
            .toList();
    }

    @Override
    public Optional<PetDto> getById(String id) {
        Optional<Pet> pet = petRepo.findById(id);

        if (pet.isPresent()) {
            return Optional.of(new PetDto(pet.get().getId(),
            pet.get().getName(),
            pet.get().getBreed(),
            pet.get().getBirthDate(),
            pet.get().isVaccinated(),
            pet.get().getProcedures()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public PetDto create(PetDto dto) {
        Pet pet = new Pet(dto);
        petRepo.save(pet);

        return new PetDto(pet.getId(),
            pet.getName(),
            pet.getBreed(),
            pet.getBirthDate(),
            pet.isVaccinated(),
            pet.getProcedures());
    }

    @Override
    public PetDto updateById(String id, PetDto dto) {
        Pet pet = petRepo.findById(id).orElse(null);

        if (pet != null) {
            Pet updatePet = new Pet(dto);
            updatePet.setId(id);
            petRepo.save(updatePet);
            
            return new PetDto(updatePet.getId(),
            updatePet.getName(),
            updatePet.getBreed(),
            updatePet.getBirthDate(),
            updatePet.isVaccinated(),
            updatePet.getProcedures());
    }

            return null;
        }

        @Override
        public void deleteById(String id) {
        petRepo.deleteById(id);
    }
    }



