package com.example.demo.eventTeam;

import com.example.demo.event.Event;
import com.example.demo.event.EventService;
import com.example.demo.mapper;
import com.example.demo.team.Team;
import com.example.demo.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTeamService {
    private EventTeamRepository eventTeamRepository;
    private EventService eventService;
    private TeamService teamService;
    @Autowired
    public EventTeamService(EventTeamRepository eventTeamRepository, EventService eventService, TeamService teamService) {
        this.eventTeamRepository = eventTeamRepository;
        this.eventService = eventService;
        this.teamService = teamService;
    }

    // GET ALL
    public List<EventTeamResponseDto> getEventTeams() {
        List<EventTeam> eventTeams = eventTeamRepository.findAll();
        List<EventTeamResponseDto> eventTeamResponseDtos= mapper.evenTeamToEventTeamResponseDtoList(eventTeams);
        return eventTeamResponseDtos;
    }
    // GET BY ID
    public EventTeamResponseDto getEventTeam(Long id) {
        EventTeam eventTeam= eventTeamRepository.findById(id).get();
        EventTeamResponseDto eventTeamResponseDto = mapper.evenTeamToEventTeamResponseDto(eventTeam);
        return eventTeamResponseDto;

    }

    public String addEventTeam(EventTeamRequestDto eventTeamRequestDto) {
        EventTeam eventTeam = new EventTeam();

        Event event = eventService.getEvent(eventTeamRequestDto.getEventId());
        Team team = teamService.getTeamById(eventTeamRequestDto.getTeamId()).get();

        eventTeam.setRegistrationDate(eventTeamRequestDto.getRegistrationDate());
        eventTeam.setEvent(event);
        eventTeam.setTeam(team);

        eventTeamRepository.save(eventTeam);

        return "Created";
    }
}
