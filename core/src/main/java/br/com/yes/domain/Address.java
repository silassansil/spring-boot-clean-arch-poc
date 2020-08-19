package br.com.yes.domain;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    private UUID id;
    private String cep;
    private String street;
    private String complement;
    private String neighborhood;
    private String location;
    private String uf;
}
