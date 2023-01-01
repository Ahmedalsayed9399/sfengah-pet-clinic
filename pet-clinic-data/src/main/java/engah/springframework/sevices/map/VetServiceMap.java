package engah.springframework.sevices.map;

import engah.springframework.model.Speciality;
import engah.springframework.model.Vet;
import engah.springframework.sevices.CrudService;
import engah.springframework.sevices.SpecialityService;
import engah.springframework.sevices.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    private final SpecialityService specialityService;
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
          super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId()==null){
                    Speciality savedSpeciality=specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save( object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
