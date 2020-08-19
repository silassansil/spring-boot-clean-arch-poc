package br.com.yes.repository;

import br.com.yes.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, UUID> {
}
