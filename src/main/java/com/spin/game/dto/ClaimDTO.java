package com.spin.game.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class ClaimDTO {
    private long gameId;
    private long ticketId;
    private long claimId;
    private String betName;
    private double betAmount;
    private double claimAmount;
}
