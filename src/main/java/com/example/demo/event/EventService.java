package com.example.demo.event;

import com.example.demo.bet.Bet;
import com.example.demo.bet.BetRepository;
import com.example.demo.bet.BetService;
import com.example.demo.eventTeam.EventTeam;
import com.example.demo.eventTeam.EventTeamRepository;
import com.example.demo.mapper;
import com.example.demo.team.Team;
import com.example.demo.team.TeamService;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.round;

@Service
public class EventService {

    private EventRepository eventRepository;
    private BetRepository betRepository;
    private UserRepository userRepository;
    private EventTeamRepository eventTeamRepository;
    @Autowired
    public EventService(EventRepository eventRepository, BetRepository betRepository, UserRepository userRepository, EventTeamRepository eventTeamRepository) {
        this.eventRepository = eventRepository;
        this.betRepository = betRepository;
        this.userRepository = userRepository;
        this.eventTeamRepository = eventTeamRepository;
    }

    // POST
    public void addEvent(EventRequestDto eventRequestDto) {
        Event event = new Event();

        event.setName(eventRequestDto.getName());
        event.setDescription(eventRequestDto.getDescription());
        // Por defecto crea los eventos sin ganador y con status "en curso"
        event.setStatus(1);
        event.setWinnerTeamId(null);
        eventRepository.save(event);

        return;
    }
    // GET BY ID
    public EventResponseDto getEventById(Long id) {
        Event event = getEvent(id);
        return mapper.eventToEventResponseDto(event);
    }
    // GET ALL
    public List<EventResponseDto> getEvents() {
        List<Event> events = eventRepository.findAll();
        return mapper.eventResponseDtoList(events);
    }
    public Event getEvent(Long id){
        return eventRepository.findById(id).get();
    }

    public void editEvent(Long idEventToEdit, EventRequestDto eventRequestDto) {
        Event eventToEdit = getEvent(idEventToEdit);

        if(eventRequestDto.getName() != null){
            eventToEdit.setName(eventRequestDto.getName());
        }
        if(eventRequestDto.getDescription() != null){
            eventToEdit.setDescription(eventRequestDto.getDescription());
        }

        // Acutaliza Winner Team y los stats de los Teams
        Long newWinnerTeam = eventRequestDto.getWinnerTeamId();
        if(newWinnerTeam != null ){
            eventToEdit.setWinnerTeamId(newWinnerTeam);
            List<EventTeam> eventTeams = eventTeamRepository.findByEvent(eventToEdit);
            Team actualTeam = new Team();
            for(EventTeam eventTeam: eventTeams){
                actualTeam = eventTeam.getTeam();
                if(newWinnerTeam == actualTeam.getId()){
                    actualTeam.setStatsWin(actualTeam.getStatsWin() + 1);
                } else {
                    actualTeam.setStatsLose(actualTeam.getStatsLose() + 1);
                }
                eventTeamRepository.save(eventTeam);
            }
        }

        int newStatus = eventRequestDto.getStatus();
        if(newStatus != 0 && (eventToEdit.getStatus() != newStatus)){
            eventToEdit.setStatus(newStatus);
            if (newStatus == 2) {
                // Actualiza Bets
                List<Bet> bets = betRepository.findByEvent(eventToEdit);
                for (Bet bet : bets) {
                    bet.setStatus(newStatus);
                    betRepository.save(bet);
                    // Actualiza los users y sus points
                    if(eventToEdit.getWinnerTeamId() != null)      {
                        User userPoint = bet.getUser();
                        if(eventToEdit.getWinnerTeamId() == bet.getWinner()){
                            Long ganancia = round(bet.getAmount() * bet.getMultiplier());
                            userPoint.setPoints(userPoint.getPoints() + ganancia);
                        }
                        userRepository.save(userPoint);
                    }
                }
            }
        }
        eventRepository.save(eventToEdit);
        return;

    }
}
