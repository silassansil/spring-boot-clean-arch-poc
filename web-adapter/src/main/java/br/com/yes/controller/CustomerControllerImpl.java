package br.com.yes.controller;

import br.com.yes.annotation.WebAdapter;
import br.com.yes.controller.dto.CustomerDTO;
import br.com.yes.domain.Customer;
import br.com.yes.usecase.address.FindAddressByCepUseCase;
import br.com.yes.usecase.customer.FindAllCustomerUserCase;
import br.com.yes.usecase.customer.SaveCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@WebAdapter
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerControllerImpl {

    private final SaveCustomerUseCase saveCustomerUseCase;
    private final FindAddressByCepUseCase findAddressByCepUseCase;
    private final FindAllCustomerUserCase findAllCustomerUserCase;

    @PostMapping
    public ResponseEntity<CustomerDTO> save(@Valid @RequestBody CustomerDTO resource) {
        final var address = this.findAddressByCepUseCase.doExecute(resource.getCep());
        final var customer = this.saveCustomerUseCase.doExecute(new Customer(resource.toDomain(), address));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CustomerDTO.toDto(customer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        return ResponseEntity
                .ok(this.findAllCustomerUserCase.doExecute()
                        .stream()
                        .map(CustomerDTO::toDto)
                        .collect(toList()));
    }
}
