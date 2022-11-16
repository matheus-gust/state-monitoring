package br.edu.fema.apistatemonitoring.requests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientMessage {
    private UUID clientId;
    private String clientDescrption;
    private String clientAddress;
    private Integer clientPort;
}