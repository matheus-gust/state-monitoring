package br.edu.fema.apistatemonitoring.client.service;

import br.edu.fema.apistatemonitoring.client.model.Client;
import br.edu.fema.apistatemonitoring.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client defineCliente(UUID clienteTenant, String clientDescription) {
        Optional<Client> client = this.clientRepository.findByTenant(clienteTenant);
        if(client.isPresent()) {
            return client.get();
        }
        return this.clientRepository.save(new Client(clienteTenant, clientDescription));
    }
}
