package br.com.yes.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@AllArgsConstructor
public class CustomerNameAndCepDTO implements Serializable {

    @NotBlank
    private final String name;

    @NotBlank
    private final String cep;
}
