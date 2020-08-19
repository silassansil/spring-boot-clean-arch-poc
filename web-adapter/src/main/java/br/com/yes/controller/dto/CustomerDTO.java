package br.com.yes.controller.dto;

import br.com.yes.domain.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CustomerDTO extends AbstractDTO<Customer> {

    private UUID id;

    @NotBlank
    private String name;

    private AddressDTO address;

    public CustomerDTO(UUID id, String name, AddressDTO addressDTO) {
        this.id = id;
        this.name = name;
        this.address = addressDTO;
    }

    @Override
    public Customer toDomain() {
        return new Customer(this.id, false, this.name, this.address.toDomain());
    }

    public static CustomerDTO toDto(final Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getName(), AddressDTO.toDto(customer.getAddress()));
    }
}
