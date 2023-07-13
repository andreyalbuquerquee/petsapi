package br.com.tech4me.petsapi.shared;

import java.util.List;

public record PetDto (String id, String name, String breed, int birthDate, boolean vaccinated, List<String> procedures) {
    
}
