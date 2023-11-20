package com.example.demo.team;

import com.example.demo.event.EventRequestDto;
import com.example.demo.event.EventResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<String> addTeam(@RequestBody TeamRequestDto teamRequestDto) {
        teamService.addTeam(teamRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Team created.");
    }

    @GetMapping
    public ResponseEntity<List<TeamResponseDto>> getTeams(){
        List<TeamResponseDto> teamResponseDtos = teamService.getTeams();
        return new ResponseEntity<>(teamResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDto> getTeam(@PathVariable Long id){
        TeamResponseDto teamResponseDto= teamService.getTeam(id);
        if(teamResponseDto != null){
            return new ResponseEntity<>(teamResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
