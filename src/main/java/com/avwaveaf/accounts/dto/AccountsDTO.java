package com.avwaveaf.accounts.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountsDTO {
    @NotNull(message = "Customer Account Number cannot be null")
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
