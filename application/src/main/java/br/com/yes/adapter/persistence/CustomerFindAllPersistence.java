package br.com.yes.adapter.persistence;

import br.com.yes.domain.Customer;

import java.util.List;

public interface CustomerFindAllPersistence {

    List<Customer> doExecute();
}
