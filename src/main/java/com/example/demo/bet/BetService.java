package com.example.demo.bet;

import com.example.demo.event.Event;
import com.example.demo.event.EventService;
import com.example.demo.team.Team;
import com.example.demo.team.TeamService;
import com.example.demo.user.User;
import com.example.demo.mapper;
import com.example.demo.user.UserService;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BetService {

    private BetRepository betRepository;
    private UserService userService;
    private EventService eventService;
    private TeamService teamService;

    @Autowired
    public BetService(BetRepository betRepository, UserService userService,  EventService eventService, TeamService teamService) {
        this.betRepository = betRepository;
        this.userService = userService;
        this.eventService = eventService;
        this.teamService = teamService;
    }


    // POST
    public void addBet(BetRequestDto betRequestDto) {
        Bet bet = new Bet();
        bet.setAmount(betRequestDto.getAmount());
        bet.setMultiplier(betRequestDto.getMultiplier());
        bet.setStatus(1); // En curso

        if(teamService.getTeamById(betRequestDto.getWinner()).isPresent() ){
            bet.setWinner(betRequestDto.getWinner());
        }else {
            throw new IllegalArgumentException("El equipo al que apostaste no existe");
        }

        User user = userService.getUser(betRequestDto.getUserId());
        bet.setUser(user);

        Event event = eventService.getEvent(betRequestDto.getEventId());
        bet.setEvent(event);

        Bet betSaved = betRepository.save(bet);
        return;

    }

    //  GET BY ID
    public BetResponseDto getBetById(Long id) {
        Bet bet = betRepository.findById(id).get();
        return mapper.betToBetResponseDto(bet);

    }

    // GET ALL
    public List<BetResponseDto> getBets() {
        List<Bet> bets = betRepository.findAll();
        List<BetResponseDto> betResponseDtos = new ArrayList();

        betResponseDtos = mapper.betsToBetResponseDtos(bets);

        return betResponseDtos;
    }


    public void editBet(Long idToEdit, BetRequestDto betRequestDto) {
        Bet betToEdit = betRepository.findById(idToEdit).get();

        if(betRequestDto.getWinner() != null){
            betToEdit.setWinner(betRequestDto.getWinner());
        }
        if(betRequestDto.getMultiplier() != 0){
            betToEdit.setMultiplier(betRequestDto.getMultiplier());
        }
        if(betRequestDto.getAmount() != 0){
            betToEdit.setAmount(betRequestDto.getAmount());
        }
        // No se edita userId ni eventId porque es un metodo accesible para el usuario
        betRepository.save(betToEdit);

    }

}
