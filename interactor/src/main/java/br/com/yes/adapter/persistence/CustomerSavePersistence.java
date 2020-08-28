package br.com.yes.adapter.persistence;

import br.com.yes.domain.Customer;

public interface CustomerSavePersistence {

    Customer doExecute(final Customer customer);
}
