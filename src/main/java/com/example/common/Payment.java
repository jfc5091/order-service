package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //essentially handles @Getter, @Setter, @ToString, @EqualsAndHashCode for entity
@AllArgsConstructor //automatically generates a constructor with a parameter for each field in your class (unless that field is a *defined* final var)
@NoArgsConstructor //generates a default constructor with no parameters
public class Payment {

    private int paymentId;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
}
