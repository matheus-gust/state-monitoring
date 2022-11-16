package br.edu.fema.apistatemonitoring.requests.api;

import br.edu.fema.apistatemonitoring.client.model.Client;
import br.edu.fema.apistatemonitoring.client.service.ClientService;
import br.edu.fema.apistatemonitoring.requests.model.HttpRequestForm;
import br.edu.fema.apistatemonitoring.requests.model.HttpRequest;
import br.edu.fema.apistatemonitoring.requests.repository.HttpRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class HttpRequestController {

    private final ClientService clientService;
    private final HttpRequestRepository httpRequestRepository;

    public ResponseEntity<Void> insertHttpRequest(@RequestBody HttpRequestForm httpRequestForm) {
        Client client = this.clientService.defineCliente(httpRequestForm.getClientId(), httpRequestForm.getClientDescrption());
        HttpRequest request = httpRequestForm.toModel();
        request.setClient(client);
        this.httpRequestRepository.save(request);
        return ResponseEntity.ok().build();
    }
}
