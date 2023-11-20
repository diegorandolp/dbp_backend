package com.example.demo.event;

import java.util.List;

public class EventResponseDto {
    private Long id;
    private String name;
    private String description;
    private int status;
    private List<Long> betIds;
    private List<Long> eventoTeamIds;
    private Long winnerTeamId;
    // Constructo, gettes y setters
    public EventResponseDto (){}

    public EventResponseDto(Long id, String name, String description, int status, List<Long> betIds, List<Long> eventoTeamIds, Long winnerTeamId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.betIds = betIds;
        this.eventoTeamIds = eventoTeamIds;
        this.winnerTeamId = winnerTeamId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Long> getBetIds() {
        return betIds;
    }

    public void setBetIds(List<Long> betIds) {
        this.betIds = betIds;
    }

    public List<Long> getEventoTeamIds() {
        return eventoTeamIds;
    }

    public void setEventoTeamIds(List<Long> eventoTeamIds) {
        this.eventoTeamIds = eventoTeamIds;
    }

    public Long getWinnerTeamId() {
        return winnerTeamId;
    }

    public void setWinnerTeamId(Long winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
