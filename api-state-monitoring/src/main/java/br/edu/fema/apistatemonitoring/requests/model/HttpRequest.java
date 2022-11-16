package br.edu.fema.apistatemonitoring.requests.model;

import br.edu.fema.apistatemonitoring.client.model.Client;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class HttpRequest {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @NotNull
    private UUID id;
    @NotNull
    private Integer status;

    @NotNull
    private String method;
    @NotNull
    private String body;
    @NotNull
    private String sender;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @NotNull
    private Client client;

    public HttpRequest(Integer status, String body, String method, String sender) {
        this.status = status;
        this.body = body;
        this.sender = sender;
        this.method = method;
    }
}
