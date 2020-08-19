package br.com.yes.controller.dto;

import br.com.yes.domain.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO extends AbstractDTO<Address> {

    @JsonProperty("id")
    private final UUID id;

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
        return Address.builder()
                .id(this.id)
                .cep(this.cep)
                .street(this.street)
                .complement(this.complement)
                .neighborhood(this.neighborhood)
                .location(this.location)
                .uf(this.uf)
                .build();
    }

    public static AddressDTO toDto(final Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .cep(address.getCep())
                .street(address.getStreet())
                .complement(address.getComplement())
                .neighborhood(address.getNeighborhood())
                .location(address.getLocation())
                .uf(address.getUf())
                .build();
    }
}
