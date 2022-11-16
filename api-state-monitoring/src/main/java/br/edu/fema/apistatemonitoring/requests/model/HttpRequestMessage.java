package br.edu.fema.apistatemonitoring.requests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HttpRequestMessage {
    private Integer status;
    private String body;
    private String method;
    private String sender;
}
