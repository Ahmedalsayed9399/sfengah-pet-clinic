package engah.springframework.sevices.springdatajpa;

import engah.springframework.model.Owner;
import engah.springframework.repositories.OwnerRepository;
import engah.springframework.repositories.PetRepository;
import engah.springframework.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static final String Last_Name="smith";
    @Mock
     OwnerRepository ownerRepository;
    @Mock
     PetRepository petRepository;
    @Mock
     PetTypeRepository petTypeRepository;
    @InjectMocks
     OwnerSDJpaService service;
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner=Owner.builder().id(1L).lastName(Last_Name).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnownerSet=new HashSet<>();
        returnownerSet.add(Owner.builder().id(1L).build());
        returnownerSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(returnownerSet);
        Set<Owner> owners=service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner=service.findById(1L);
        assertNotNull(owner);
    }
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner=service.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave=Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner saveOwner=service.save(ownerToSave);
        assertNotNull(saveOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
       verify(ownerRepository,times(1)).delete(any());

    }

    @Test
    void deleteById() {
       service.deleteById(1L);
       verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith=service.findByLastName(Last_Name);
        assertEquals(Last_Name,smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}