package com.avwaveaf.accounts.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerDTO {
    private String name;
    @NotNull(message = "Customer Email Cannot be null")
    private String email;
    @NotNull(message = "mobile number cannot be null")
    private String mobileNumber;
    private AccountsDTO accounts;
}
