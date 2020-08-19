package br.com.yes.controller.dto;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
public abstract class AbstractDTO<D> implements Serializable {

    private UUID id;

    public AbstractDTO() {
    }

    public AbstractDTO(UUID id) {
        this.id = id;
    }

    public abstract D toDomain();
}
