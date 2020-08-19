package br.com.yes.entity;

import br.com.yes.domain.Address;
import br.com.yes.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity extends AbstractEntity<Customer> {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private Boolean active;

    @Override
    public Customer toDomain() {
        return new Customer(this.id, this.name);
    }

    public static CustomerEntity toEntity(final Customer customer) {
        return new CustomerEntity(customer.getId(), customer.getName(), customer.getActive());
    }
}
