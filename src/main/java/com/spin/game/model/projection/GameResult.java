package com.spin.game.model.projection;

import java.time.LocalDateTime;

public interface GameResult {
    public int getResultValue();
    public LocalDateTime getGameTimeStamp();
}
