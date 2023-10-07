package com.spin.game.mapper;

import com.spin.game.dto.ClaimDTO;
import com.spin.game.entities.ClaimBet;

public class Mapper {
    public static ClaimDTO toClaimDTO(ClaimBet claim){
        return ClaimDTO.builder()
                .gameId(claim.getGame().getGameId())
                .claimId(claim.getClaimBetId())
                .claimAmount(claim.getAmount())
                .betAmount(claim.getBet().getAmount())
                .betName(claim.getBet().getBetName())
                .ticketId(claim.getTicket().getTicketId())
                .build();
    }

}
