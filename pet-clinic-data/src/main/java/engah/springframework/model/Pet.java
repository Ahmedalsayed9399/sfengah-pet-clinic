package engah.springframework.model;

import java.time.LocalDate;

public class Pet {
    private petType petType;
    private Owner owner;
    private LocalDate birthdate;

    public engah.springframework.model.petType getPetType() {
        return petType;
    }

    public void setPetType(engah.springframework.model.petType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
