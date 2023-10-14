package com.spin.game.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class TicketReportDTO {
    private long ticketId;
    private LocalDateTime timestamp;
    private long betId;
    private double betAmount;
    private String betName;
    private double amountWon;
}
