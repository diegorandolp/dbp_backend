package com.example.demo.bet;

import io.swagger.models.auth.In;

public class BetRequestDto {
    private Long winner;
    private double multiplier;
    private int status;
    private double amount;
    private Long userId;
    private Long eventId;


    // Constructores, getters y setters
    public BetRequestDto() {
    }

    public BetRequestDto(Long winner, double multiplier, int status, double amount, Long userId, Long eventId) {
        this.winner = winner;
        this.multiplier = multiplier;
        this.status = status;
        this.amount = amount;
        this.userId = userId;
        this.eventId = eventId;
    }

    public Long getWinner() {
        return winner;
    }

    public void setWinner(Long winner) {
        this.winner = winner;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
