package br.com.tech4me.petsapi.shared;

import java.util.List;

public record PetListDto (String id, String name, List<String> procedures){
    
}
