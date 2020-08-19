package br.com.yes.adapter;

import br.com.yes.adapter.persistence.CustomerSavePersistence;
import br.com.yes.annotation.PersistenceAdapter;
import br.com.yes.domain.Customer;
import br.com.yes.entity.CustomerEntity;
import br.com.yes.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class CustomerSavePersistenceImpl implements CustomerSavePersistence {

    private final CustomerRepository customerRepository;

    @Override
    public Customer doExecute(Customer customer) {
        final var save = this.customerRepository.save(CustomerEntity.toEntity(customer));
        return save.toDomain();
    }
}
