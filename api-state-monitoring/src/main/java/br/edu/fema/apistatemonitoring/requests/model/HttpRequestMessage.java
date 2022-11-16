package br.edu.fema.apistatemonitoring.requests.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HttpRequestMessage {
    private Integer status;
    private String body;
    private String method;
    private String sender;
    private String requestedUrl;
    private String message;
    private String requestDateTime;
}
