package br.com.yes.usecase.address;

import br.com.yes.domain.Address;

public interface FindAddressByCepUseCase {

    Address doExecute(final String cep);
}
