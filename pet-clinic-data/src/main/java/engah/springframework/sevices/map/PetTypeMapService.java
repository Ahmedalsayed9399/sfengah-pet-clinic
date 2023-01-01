package engah.springframework.sevices.map;

import engah.springframework.model.petType;
import engah.springframework.sevices.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PetTypeMapService extends AbstractMapService<petType,Long> implements PetTypeService {
    @Override
    public Set<petType> findAll() {
        return super.findAll();
    }

    @Override
    public petType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public petType save(petType object) {
        return super.save(object);
    }

    @Override
    public void delete(petType object) {
super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
super.deleteById(id);
    }
}
