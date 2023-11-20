package com.example.demo.bet;

import com.example.demo.event.Event;
import com.example.demo.user.User;
import io.swagger.models.auth.In;
import jakarta.persistence.*;


@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long winner; // Id del equipo que el usuario cree que ganara
    private double multiplier;
    private int status; // 1: En curso, 2: Finalizado
    private double amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;


    // Contructor, Getters and Setters
    public Bet() {}

    public Bet(Long winner, double multiplier, int status, double amount) {
        this.winner = winner;
        this.multiplier = multiplier;
        this.status = status;
        this.amount = amount;
    }
    //---------------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
