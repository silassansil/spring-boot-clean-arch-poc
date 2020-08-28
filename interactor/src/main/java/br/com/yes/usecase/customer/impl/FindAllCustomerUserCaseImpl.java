package br.com.yes.usecase.customer.impl;

import br.com.yes.adapter.persistence.CustomerFindAllPersistence;
import br.com.yes.annotation.UseCase;
import br.com.yes.domain.Customer;
import br.com.yes.usecase.customer.FindAllCustomerUserCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllCustomerUserCaseImpl implements FindAllCustomerUserCase {

    private final CustomerFindAllPersistence customerFindAllPersistence;

    @Override
    public List<Customer> doExecute() {
        return this.customerFindAllPersistence.doExecute();
    }
}
