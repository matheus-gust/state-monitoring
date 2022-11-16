package br.edu.fema.apistatemonitoring.requests.model;

import br.edu.fema.apistatemonitoring.requests.model.HttpRequest;
import lombok.Data;

import java.util.UUID;

@Data
public class HttpRequestForm {

    private Integer status;
    private String body;
    private String sender;
    private UUID clientId;
    private String clientDescrption;

    public HttpRequest toModel() {
        return new HttpRequest(this.status, this.body, this.sender);
    }
}
