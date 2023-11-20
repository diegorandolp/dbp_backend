package com.example.demo.eventTeam;

import com.example.demo.bet.Bet;
import com.example.demo.event.Event;
import com.example.demo.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventTeamRepository extends JpaRepository<EventTeam, Long> {
    List<EventTeam> findByEvent(Event event);
    List<EventTeam> findByTeam(Team team);
}
