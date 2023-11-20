package com.example.demo.team;

import com.example.demo.event.Event;
import java.util.List;

public class TeamResponseDto {
    Long id;
    String logo;
    String name;
    Integer statsWin;
    Integer statsLose;
    List<Long> eventTeamIds;

    public TeamResponseDto(){}

    public TeamResponseDto(Long id, String logo, String name, Integer statsWin, Integer statsLose, List<Long> eventTeamIds) {
        this.id = id;
        this.logo = logo;
        this.name = name;
        this.statsWin = statsWin;
        this.statsLose = statsLose;
        this.eventTeamIds = eventTeamIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatsWin() {
        return statsWin;
    }

    public void setStatsWin(Integer statsWin) {
        this.statsWin = statsWin;
    }

    public Integer getStatsLose() {
        return statsLose;
    }

    public void setStatsLose(Integer statsLose) {
        this.statsLose = statsLose;
    }

    public List<Long> getEventTeamIds() {
        return eventTeamIds;
    }

    public void setEventTeamIds(List<Long> eventTeamIds) {
        this.eventTeamIds = eventTeamIds;
    }
}
