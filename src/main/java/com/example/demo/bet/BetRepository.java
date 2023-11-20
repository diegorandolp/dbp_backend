package com.example.demo.bet;

import com.example.demo.bet.Bet;
import com.example.demo.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findByEvent(Event event);
}
