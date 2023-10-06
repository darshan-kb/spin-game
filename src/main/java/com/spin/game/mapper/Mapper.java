package com.spin.game.mapper;

import com.spin.game.dto.ClaimDTO;
import com.spin.game.entities.ClaimBet;

public class Mapper {
    public static ClaimDTO toClaimDTO(ClaimBet claim){
        return ClaimDTO.builder()
                .gameId(claim.getGame().getGameId())
                .claimId(claim.getClaimBetId())
                .amount(claim.getAmount())
                .ticketId(claim.getTicket().getTicketId())
                .build();
    }

}
