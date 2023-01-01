package engah.springframework.bootstrap;

import engah.springframework.model.*;
import engah.springframework.sevices.OwnerService;
import engah.springframework.sevices.PetTypeService;
import engah.springframework.sevices.SpecialityService;
import engah.springframework.sevices.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
 private final OwnerService ownerService;
  private  final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialityService specialityService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count=petTypeService.findAll().size();
       if(count==0){
           loadData();}
    }

    private void loadData() {
        petType dog=new petType();
        dog.setName("Dog");
        petType savedDogPetType=petTypeService.save(dog);
        petType cat=new petType();
        dog.setName("Cat");
        petType savedCatPetType=petTypeService.save(cat);
        Speciality radiology=new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology=specialityService.save(radiology);
        Speciality surgery=new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery=specialityService.save(surgery);

        Speciality dentistry=new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry=specialityService.save(dentistry);

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
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);
        Vet vet2=new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("load vets is done!....");
    }
}
