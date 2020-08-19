package br.com.yes.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Customer implements Serializable {

    private UUID id;
    private boolean active;

    private final String name;
    private final Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void active() {
        this.active = !this.name.isBlank() && this.name.equals("JOW");
    }
}
