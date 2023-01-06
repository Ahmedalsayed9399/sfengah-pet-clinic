package engah.springframework.sevices.map;

import engah.springframework.model.Visit;
import engah.springframework.sevices.PetService;
import engah.springframework.sevices.PetTypeService;
import engah.springframework.sevices.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})

public class VisitMapService extends AbstractMapService<Visit,Long>implements VisitService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public VisitMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet()==null||visit.getPet().getOwner()==null||visit.getPet().getId()==null
        ||visit.getPet().getOwner().getId()==null){
            throw new RuntimeException("Invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
super.deleteById(id);
    }
}
