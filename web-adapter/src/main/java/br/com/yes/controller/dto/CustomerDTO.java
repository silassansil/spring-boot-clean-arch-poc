package br.com.yes.controller.dto;

import br.com.yes.domain.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CustomerDTO extends AbstractDTO<Customer> {

    @NotBlank
    private String name;

    private AddressDTO address;

    private String cep;

    public CustomerDTO(String name, String cep) {
        this.name = name;
        this.cep = cep;
    }

    public CustomerDTO(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public CustomerDTO(UUID id, String name, AddressDTO addressDTO) {
        this(id, name);
        this.address = addressDTO;
    }

    @Override
    public Customer toDomain() {
        return new Customer(UUID.randomUUID(), this.name);
    }

    public static CustomerDTO toDto(final Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getName(), AddressDTO.toDto(customer.getAddress()));
    }
}
