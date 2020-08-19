package br.com.yes.entity;

import java.io.Serializable;

public abstract class AbstractEntity<D> implements Serializable {

    protected abstract D toDomain();
}
