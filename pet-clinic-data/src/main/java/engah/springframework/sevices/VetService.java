package engah.springframework.sevices;

import engah.springframework.model.Owner;
import engah.springframework.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
