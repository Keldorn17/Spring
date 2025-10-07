package com.keldorn.employeerest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String type;
    private String title;
    private String detail;

    @JsonIgnore
    private HttpStatusCode statusCode;

    @JsonProperty("statusCode")
    public int getStatusCode() {
        return statusCode.value();
    }
}
