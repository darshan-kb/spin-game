package com.spin.game.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SsePayload {
    private String payloadName;
    private int payloadValue;
}
