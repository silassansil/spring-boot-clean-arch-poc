package br.com.yes.domain;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
public class Customer implements Serializable {
    private final UUID id;
    private final String name;
    private Boolean active;
    private Address address;

    public Customer(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.active = Boolean.FALSE;
    }

    public Customer(Customer customer, Address address) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.active = customer.getActive();
        this.address = address;
    }

    public void active() {
        this.active = !this.name.isBlank() && this.name.equals("JOW");
    }
}
