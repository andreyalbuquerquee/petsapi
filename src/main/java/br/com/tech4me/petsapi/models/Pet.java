package br.com.tech4me.petsapi.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.petsapi.shared.PetDto;

@Document("pets")
public class Pet {
    @Id
    private String id;
    private String name;
    private String breed;
    private int birthDate;
    private boolean vaccinated;
    private List<String> procedures;
    
    
    public Pet() {}

    public Pet(PetDto dto) {
        this.id = dto.id();
        this.name = dto.name();
        this.breed = dto.breed();
        this.birthDate = dto.birthDate();
        this.vaccinated = dto.vaccinated();
        this.procedures = dto.procedures();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public int getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }
    public boolean isVaccinated() {
        return vaccinated;
    }
    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
    public List<String> getProcedures() {
        return procedures;
    }
    public void setProcedures(List<String> procedures) {
        this.procedures = procedures;
    }
}
