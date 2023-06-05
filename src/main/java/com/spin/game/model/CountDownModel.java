package com.spin.game.model;

import org.springframework.messaging.core.MessagePostProcessor;

public class CountDownModel {
    private int varcount;
    public CountDownModel(int varcount) {
        this.varcount = varcount;
    }

    public int getVarcount() {
        return varcount;
    }

    public void setVarcount(int varcount) {
        this.varcount = varcount;
    }
}
