package br.com.yes.entity;

import br.com.yes.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity extends AbstractEntity<Customer> {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private Boolean active;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private AddressEntity address;

    @Override
    public Customer toDomain() {
        return new Customer(this.id, this.active, this.name, this.address.toDomain());
    }

    public static CustomerEntity toEntity(final Customer customer) {
        return new CustomerEntity(UUID.randomUUID(), customer.getName(), customer.isActive(), AddressEntity.toEntity(customer.getAddress()));
    }
}
