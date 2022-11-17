package br.edu.fema.apistatemonitoring.requests.api;

import br.edu.fema.apistatemonitoring.requests.model.HttpRequest;
import br.edu.fema.apistatemonitoring.requests.repository.HttpRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(path = "httprequest")
public class RequestController {

    @Autowired
    private HttpRequestRepository httpRequestRepository;

    @GetMapping(path = "/list/{tenantId}")
    public ResponseEntity<List<HttpRequest>> listHttpRequest(@PathVariable UUID tenantId) {
        return ResponseEntity.ok(this.httpRequestRepository.findAllByClientTenant(tenantId));
    }
}
