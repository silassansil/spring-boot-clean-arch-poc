package br.com.yes;

import br.com.yes.adapter.integration.FindAddressByCepIntegration;
import br.com.yes.annotation.IntegrationAdapter;
import br.com.yes.domain.Address;
import br.com.yes.integrationdomain.AddressIntegration;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@IntegrationAdapter
@RequiredArgsConstructor
public class FindAddressByCepIntegrationImpl implements FindAddressByCepIntegration {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    @Override
    public Address doExecute(String cep) {
        try {
            final var request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json"))
                    .build();
            final HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return new ObjectMapper().readValue(response.body(), AddressIntegration.class).toDomain();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("erro during find address by cep");
        }
    }
}
