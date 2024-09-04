package com.snapwork.SBI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankInfo {
    private String accountNumber;
    private String bankName;
    private String branch;
    // Add other relevant fields, getters, and setters

    // Constructors, getters, and setters
}

