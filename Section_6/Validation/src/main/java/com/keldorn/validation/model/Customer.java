package com.keldorn.validation.model;

import com.keldorn.validation.annotation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater then or equal to zero")
    @Max(value = 10, message = "must be less then or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 characters/digits")
    private String postalCode;

    @CourseCode(value = "LUV", message = "must start with LUV")
    private String courseCode;
}
