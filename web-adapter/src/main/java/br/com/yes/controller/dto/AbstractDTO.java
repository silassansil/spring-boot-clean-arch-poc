package br.com.yes.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractDTO<D> implements Serializable {

    public abstract D toDomain();
}
