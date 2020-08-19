package br.com.yes.adapter;

import br.com.yes.adapter.persistence.CustomerFindAllPersistence;
import br.com.yes.annotation.PersistenceAdapter;
import br.com.yes.domain.Customer;
import br.com.yes.entity.CustomerEntity;
import br.com.yes.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@PersistenceAdapter
@RequiredArgsConstructor
public class CustomerFindAllPersistenceImpl implements CustomerFindAllPersistence {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> doExecute() {
        return stream(this.customerRepository.findAll().spliterator(), false)
                .map(CustomerEntity::toDomain)
                .collect(toList());
    }
}
