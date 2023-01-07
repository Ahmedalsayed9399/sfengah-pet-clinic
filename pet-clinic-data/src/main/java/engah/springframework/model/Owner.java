package engah.springframework.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor


@Entity
@Table(name = "owners")
public class Owner extends Person{
    @Builder
    public Owner(Long id,String firstName,String lastName,String address,
                 String telephone, String city, Set<Pet> pets) {
        super(id,firstName,lastName);
        this.address = address;
        Telephone = telephone;
        this.city = city;
        this.pets = pets;
    }



    @Column(name = "address")
    private String address;
    @Column(name = "telephone")
    private String Telephone;
    @Column(name = "city")
    private String city;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> pets=new HashSet<>();


}
