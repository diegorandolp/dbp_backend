package com.example.demo.event;

import java.util.List;

public class EventRequestDto {
    private String name;
    private String description;
    private Long winnerTeamId;
    private int status;
    // Constructor, getters y setters


    public EventRequestDto(String name, String description, Long winnerTeamId, int status) {
        this.name = name;
        this.description = description;
        this.winnerTeamId = winnerTeamId;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getWinnerTeamId() {
        return winnerTeamId;
    }

    public void setWinnerTeamId(Long winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
    }
}
