package engah.springframework.sevices;

import engah.springframework.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findBylastName(String lastname);
    Owner findById(Long id);
    Owner save(Owner owner);
Set<Owner> findAll();
}
