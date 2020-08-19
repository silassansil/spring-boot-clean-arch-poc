package br.com.yes.entity;

import br.com.yes.domain.Address;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity extends AbstractEntity<Address> {

    @Id
    @GeneratedValue
    private UUID id;
    private String cep;
    private String street;

    @Override
    protected Address toDomain() {
        return Address.builder()
                .id(this.id)
                .cep(this.cep)
                .street(this.street)
                .build();
    }


    public static AddressEntity toEntity(final Address address) {
        return new AddressEntity(address.getId(), address.getCep(), address.getStreet());
    }
}
