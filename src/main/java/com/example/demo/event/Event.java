package com.example.demo.event;

import com.example.demo.bet.Bet;
import com.example.demo.eventTeam.EventTeam;
import com.example.demo.team.Team;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Long winnerTeamId;
    private int status; // 1: En curso, 2: Finalizado
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event", cascade = CascadeType.ALL)
    private List<Bet> bets;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventTeam> eventTeams;

    //métodos getter/setter
    public Event() {}

    public Event(String name, String description, Long winnerTeamId, int status) {
        this.name = name;
        this.description = description;
        this.winnerTeamId = winnerTeamId;
        this.status = status;
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

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public List<EventTeam> getEventTeams() {
        return eventTeams;
    }

    public void setEventTeams(List<EventTeam> eventTeams) {
        this.eventTeams = eventTeams;
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