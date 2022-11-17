package br.edu.fema.apistatemonitoring.requests.repository;

import br.edu.fema.apistatemonitoring.requests.model.HttpRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HttpRequestRepository extends JpaRepository<HttpRequest, UUID> {
    List<HttpRequest> findAllByClientTenant(UUID tenant);
}
