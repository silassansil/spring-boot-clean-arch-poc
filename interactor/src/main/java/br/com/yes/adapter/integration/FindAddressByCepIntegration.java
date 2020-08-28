package br.com.yes.adapter.integration;

import br.com.yes.domain.Address;

public interface FindAddressByCepIntegration {

    Address doExecute(final String cep);
}
