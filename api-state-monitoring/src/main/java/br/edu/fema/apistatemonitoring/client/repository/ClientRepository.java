package br.edu.fema.apistatemonitoring.client.repository;

import br.edu.fema.apistatemonitoring.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByTenant(UUID teant);
}
