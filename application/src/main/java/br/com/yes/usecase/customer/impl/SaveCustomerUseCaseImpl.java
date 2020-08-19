package br.com.yes.usecase.customer.impl;

import br.com.yes.adapter.persistence.CustomerSavePersistence;
import br.com.yes.annotation.UseCase;
import br.com.yes.domain.Customer;
import br.com.yes.usecase.customer.SaveCustomerUseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveCustomerUseCaseImpl implements SaveCustomerUseCase {

    private final CustomerSavePersistence customerSavePersistence;

    @Override
    public Customer doExecute(Customer customer) {
        customer.active();
        return this.customerSavePersistence.doExecute(customer);
    }
}
