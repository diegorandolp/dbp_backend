package com.example.demo.team;

import com.example.demo.event.Event;
import com.example.demo.eventTeam.EventTeam;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String logo;
    String name;
    Integer statsWin;
    Integer statsLose;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL)
    private List<EventTeam> eventTeams;

    // metodos getter y setter

    public Team(){}

    public Team(String logo, String name, Integer statsWin, Integer statsLose) {
        this.logo = logo;
        this.name = name;
        this.statsWin = statsWin;
        this.statsLose = statsLose;
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

    public List<EventTeam> getEventTeams() {
        return eventTeams;
    }

    public void setEventTeams(List<EventTeam> eventTeams) {
        this.eventTeams = eventTeams;
    }
}
