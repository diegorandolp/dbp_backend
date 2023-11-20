package com.example.demo.team;

public class TeamRequestDto {
    String logo;
    String name;
    Integer statsWin;
    Integer statsLose;

    // getters y setters

    public TeamRequestDto(String logo, String name, Integer statsWin, Integer statsLose) {
        this.logo = logo;
        this.name = name;
        this.statsWin = statsWin;
        this.statsLose = statsLose;
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
}
