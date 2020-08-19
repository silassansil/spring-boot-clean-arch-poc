package br.com.yes.usecase.customer;

import br.com.yes.domain.Customer;

public interface SaveCustomerUseCase {

    Customer doExecute(final Customer customer);
}
