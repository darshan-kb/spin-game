package com.spin.game.service;

public interface EmailSender {
    void send(String to, String email, String subject);
}
