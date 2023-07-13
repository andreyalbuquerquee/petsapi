package br.com.tech4me.petsapi.services;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.petsapi.shared.PetDto;
import br.com.tech4me.petsapi.shared.PetListDto;

public interface PetService {
    List<PetListDto> getAll();
    Optional<PetDto> getById(String id);
    PetDto create(PetDto dto);
    PetDto updateById(String id, PetDto dto);
    void deleteById(String id);
    
}
