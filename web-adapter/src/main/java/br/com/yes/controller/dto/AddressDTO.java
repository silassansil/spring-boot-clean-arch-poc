package br.com.yes.controller.dto;

import br.com.yes.domain.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.UUID;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO extends AbstractDTO<Address> {

    public AddressDTO(UUID id, String cep, String street, String complement, String neighborhood, String location, String uf) {
        super(id);
        this.cep = cep;
        this.street = street;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.location = location;
        this.uf = uf;
    }

    @JsonProperty("cep")
    private final String cep;

    @JsonProperty("logradouro")
    private final String street;

    @JsonProperty("complemento")
    private final String complement;

    @JsonProperty("bairro")
    private final String neighborhood;

    @JsonProperty("localidade")
    private final String location;

    @JsonProperty("uf")
    private final String uf;


    @Override
    public Address toDomain() {
        return new Address(super.getId(), this.cep, this.street, this.complement, this.neighborhood, this.location, this.uf);
    }

    public static AddressDTO toDto(final Address address) {
        return new AddressDTO(
                address.getId(), address.getCep(), address.getStreet(), address.getComplement(), address.getNeighborhood(), address.getLocation(), address.getUf()
        );
    }
}
