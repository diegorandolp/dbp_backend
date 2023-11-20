package com.example.demo.eventTeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event-team")
public class EventTeamController {
    EventTeamService eventTeamService;
    @Autowired
    public EventTeamController(EventTeamService eventTeamService) {
        this.eventTeamService = eventTeamService;
    }
    @GetMapping
    public ResponseEntity<List<EventTeamResponseDto>> getEventTeams(){
        List<EventTeamResponseDto> eventTeamResponseDtos= eventTeamService.getEventTeams();
        ;return new ResponseEntity<>(eventTeamResponseDtos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventTeamResponseDto> getEventTeam(@PathVariable Long id){
        EventTeamResponseDto eventTeamResponseDto = eventTeamService.getEventTeam(id);
        return new ResponseEntity<>(eventTeamResponseDto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addEventTeam(@RequestBody EventTeamRequestDto eventTeamRequestDto){
        return new ResponseEntity<>(eventTeamService.addEventTeam(eventTeamRequestDto), HttpStatus.CREATED);
    }
}
