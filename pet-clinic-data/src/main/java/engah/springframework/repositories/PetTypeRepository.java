package engah.springframework.repositories;

import engah.springframework.model.petType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<petType,Long> {
}
