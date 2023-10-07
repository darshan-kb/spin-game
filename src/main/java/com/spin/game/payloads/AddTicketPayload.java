package com.spin.game.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddTicketPayload {
    private double amount;
    private String email;
    private String ticketId;

    public AddTicketPayload(double amount, String email) {
        this.amount = amount;
        this.email = email;
    }
}
