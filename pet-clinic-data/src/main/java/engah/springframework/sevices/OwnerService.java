package engah.springframework.sevices;

import engah.springframework.model.Owner;



public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastname);

}
