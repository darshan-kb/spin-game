package com.spin.game.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountRedeemClaimPayload {
    private String email;
    private double claimAmount;
    private String id;
}
