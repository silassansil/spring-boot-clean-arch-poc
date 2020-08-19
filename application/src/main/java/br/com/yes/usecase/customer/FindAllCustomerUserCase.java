package br.com.yes.usecase.customer;

import br.com.yes.domain.Customer;

import java.util.List;

public interface FindAllCustomerUserCase {

    List<Customer> doExecute();
}
