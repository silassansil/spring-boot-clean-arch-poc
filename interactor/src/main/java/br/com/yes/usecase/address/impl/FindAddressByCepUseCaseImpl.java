package br.com.yes.usecase.address.impl;

import br.com.yes.adapter.integration.FindAddressByCepIntegration;
import br.com.yes.annotation.UseCase;
import br.com.yes.domain.Address;
import br.com.yes.usecase.address.FindAddressByCepUseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindAddressByCepUseCaseImpl implements FindAddressByCepUseCase {

    private final FindAddressByCepIntegration findAddressByCepIntegration;

    @Override
    public Address doExecute(String cep) {
        return this.findAddressByCepIntegration.doExecute(cep);
    }
}
