package engah.springframework.bootstrap;

import engah.springframework.model.Owner;
import engah.springframework.model.Pet;
import engah.springframework.model.Vet;
import engah.springframework.model.petType;
import engah.springframework.sevices.OwnerService;
import engah.springframework.sevices.PetTypeService;
import engah.springframework.sevices.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
 private final OwnerService ownerService;
  private  final VetService vetService;
  private final PetTypeService petTypeService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        petType dog=new petType();
        dog.setName("Dog");
        petType savedDogPetType=petTypeService.save(dog);
        petType cat=new petType();
        dog.setName("Cat");
        petType savedCatPetType=petTypeService.save(cat);

        Owner owner1=new Owner();
        owner1.setFirstName("EngAhmed");
        owner1.setLastName("Elsayed");
        owner1.setAddress("94l mina gate");
        owner1.setCity("alahram gardens");
        owner1.setTelephone("01015791073");
        Pet engAhPet=new Pet();
        engAhPet.setPetType(savedDogPetType);
        engAhPet.setOwner(owner1);
        engAhPet.setBirthdate(LocalDate.now());
        engAhPet.setName("Rosco");
        owner1.getPets().add(engAhPet);

        ownerService.save(owner1);
        Owner owner2=new Owner();
        owner2.setFirstName("EngMohamed");
        owner2.setLastName("Elsayed");
        owner2.setAddress("96 block");
        owner2.setCity("almokattam");
        owner2.setTelephone("01093067367");
        Pet mohasCat=new Pet();
        mohasCat.setPetType(savedCatPetType);
        mohasCat.setOwner(owner2);
        mohasCat.setBirthdate(LocalDate.now());
        mohasCat.setName("Cat");
        owner2.getPets().add(mohasCat);
        ownerService.save(owner2);
        System.out.println("load owners is done!....");
        Vet vet1=new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);
        Vet vet2=new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);
        System.out.println("load vets is done!....");
    }
}
