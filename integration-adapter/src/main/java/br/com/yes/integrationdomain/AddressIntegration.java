package br.com.yes.integrationdomain;

import br.com.yes.domain.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressIntegration {

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("logradouro")
    private String street;

    @JsonProperty("complemento")
    private String complement;

    @JsonProperty("bairro")
    private String neighborhood;

    @JsonProperty("localidade")
    private String location;

    @JsonProperty("uf")
    private String uf;


    public Address toDomain() {
        return Address.builder()
                .cep(this.cep)
                .street(this.street)
                .complement(this.complement)
                .neighborhood(this.neighborhood)
                .location(this.location)
                .uf(this.uf)
                .build();
    }
}
