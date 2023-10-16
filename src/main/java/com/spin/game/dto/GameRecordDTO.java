package com.spin.game.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
public class GameRecordDTO {
    private LocalDateTime localDateTime;
    private int result;
}
