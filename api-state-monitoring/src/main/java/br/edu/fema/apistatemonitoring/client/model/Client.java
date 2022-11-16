package br.edu.fema.apistatemonitoring.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private UUID tenant;
    private String description;

    public Client(UUID tenant, String description) {
        this.tenant = tenant;
        this.description = description;
    }
}
