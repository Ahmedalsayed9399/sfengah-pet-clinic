package engah.springframework.bootstrap;

import engah.springframework.model.Owner;
import engah.springframework.model.Vet;
import engah.springframework.sevices.OwnerService;
import engah.springframework.sevices.VetService;
import engah.springframework.sevices.map.OwnerServiceMap;
import engah.springframework.sevices.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
 private final OwnerService ownerService;
  private  final VetService vetService;
    public DataLoader() {
        ownerService=new OwnerServiceMap();
        vetService=new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("EngAhmed");
        owner1.setLastName("Elsayed");
        ownerService.save(owner1);
        Owner owner2=new Owner();
        owner2.setId(2L);
        owner2.setFirstName("EngMohamed");
        owner2.setLastName("Elsayed");
        ownerService.save(owner2);
        System.out.println("load owners is done!....");
        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);
        Vet vet2=new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);
        System.out.println("load vets is done!....");
    }
}
