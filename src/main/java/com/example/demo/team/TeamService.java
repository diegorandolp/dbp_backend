package com.example.demo.team;

import com.example.demo.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void addTeam(TeamRequestDto teamRequestDto) {
        Team team = new Team();

        team.setName(teamRequestDto.getName());
        team.setLogo(teamRequestDto.getLogo());
        team.setStatsLose(teamRequestDto.getStatsLose());
        team.setStatsWin(teamRequestDto.getStatsWin());

        teamRepository.save(team);
        return;
    }


    public List<TeamResponseDto> getTeams() {
        List<Team> teams = teamRepository.findAll();
        List<TeamResponseDto> teamResponseDtos= mapper.teamToTeamResponseDtoList(teams);

        return teamResponseDtos;
    }


    public TeamResponseDto getTeam(Long id) {
        TeamResponseDto teamResponseDto = mapper.teamToTeamResponseDto(getTeamById(id).get());

        return teamResponseDto;
    }

    public Optional<Team> getTeamById (Long id){
        Optional<Team> team = teamRepository.findById(id);
        return team;
    }
    public void wonMatch (Long id){
        Team team= getTeamById(id).get();
        Integer wonMatches = team.getStatsWin() + 1;
        team.setStatsWin(wonMatches);
        teamRepository.save(team);
        return;
    }

    public void loseMatch(Long idTeam) {
        Team team= getTeamById(idTeam).get();
        Integer loseMatches = team.getStatsLose() + 1;
        team.setStatsLose(loseMatches);
        teamRepository.save(team);
        return;
    }
}
