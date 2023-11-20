package com.example.demo;

import com.example.demo.bet.BetResponseDto;
import com.example.demo.event.EventResponseDto;
import com.example.demo.eventTeam.EventTeam;
import com.example.demo.eventTeam.EventTeamResponseDto;
import com.example.demo.team.Team;
import com.example.demo.team.TeamResponseDto;
import com.example.demo.user.User;
import com.example.demo.bet.Bet;
import com.example.demo.event.Event;
import com.example.demo.user.UserResponseDto;

import java.util.ArrayList;
import java.util.List;

public class mapper {

    // _________________BET_________________
    public static BetResponseDto betToBetResponseDto(Bet bet){
        BetResponseDto betResponseDto = new BetResponseDto();

        betResponseDto.setId(bet.getId());
        betResponseDto.setAmount(bet.getAmount());
        betResponseDto.setMultiplier(bet.getMultiplier());
        betResponseDto.setStatus(bet.getStatus());
        betResponseDto.setWinner(bet.getWinner());

        betResponseDto.setEventId(bet.getEvent().getId());
        betResponseDto.setUserId(bet.getUser().getId());

        return betResponseDto;
    }
    public static List<BetResponseDto> betsToBetResponseDtos(List<Bet> bets){
        List<BetResponseDto> betResponseDtos= new ArrayList<>();
        for (Bet bet : bets){
            BetResponseDto betResponseDto = betToBetResponseDto(bet);
            betResponseDtos.add(betResponseDto);
        }
        return betResponseDtos;
    }

    // _________________USER_________________

    public static UserResponseDto userToUserResponseDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setName(user.getName());
        userResponseDto.setLastname(user.getLastname());
        userResponseDto.setPoints(user.getPoints());
        userResponseDto.setUsername(user.getUsername());

        List<Long> ids = new ArrayList<>();
        List<Bet> bets = user.getBet();

        for(Bet bet : bets){
            ids.add(bet.getId());
        }
        userResponseDto.setBetIds(ids);
        return userResponseDto;
    }

    public static List<UserResponseDto> userResponseDtoList(List<User> userList){
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for(User user : userList){
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto = userToUserResponseDto(user);
            userResponseDtos.add(userResponseDto);
        }
        return userResponseDtos;
    }
    // _________________EVENT_________________
    public static EventResponseDto eventToEventResponseDto(Event event){
        EventResponseDto eventResponseDto = new EventResponseDto();

        eventResponseDto.setName(event.getName());
        eventResponseDto.setDescription(event.getDescription());
        eventResponseDto.setId(event.getId());
        eventResponseDto.setStatus(event.getStatus());
        eventResponseDto.setWinnerTeamId(event.getWinnerTeamId());

        List<Long> ids = new ArrayList<>();
        List<Bet> bets = event.getBets();

        for(Bet bet: bets){
            ids.add(bet.getId());
        }
        eventResponseDto.setBetIds(ids);

        List<Long> eventTeamids = new ArrayList<>();
        List<EventTeam> eventTeams = event.getEventTeams();
        for(EventTeam eventTeam: eventTeams){
            eventTeamids.add(eventTeam.getId());
        }
        eventResponseDto.setEventoTeamIds(eventTeamids);

        return eventResponseDto;
    }
    public static List<EventResponseDto> eventResponseDtoList(List<Event> eventList){
        List<EventResponseDto> eventResponseDtos = new ArrayList<>();
        for(Event event: eventList){
            EventResponseDto eventResponseDto = new EventResponseDto();
            eventResponseDto = eventToEventResponseDto(event);
            eventResponseDtos.add(eventResponseDto);
        }
        return eventResponseDtos;
    }
    //_______________________TEAM____________________________
    public static TeamResponseDto teamToTeamResponseDto(Team team){
        TeamResponseDto teamResponseDto = new TeamResponseDto();

        teamResponseDto.setId(team.getId());
        teamResponseDto.setLogo(team.getLogo());
        teamResponseDto.setName(team.getName());
        teamResponseDto.setStatsLose(team.getStatsLose());
        teamResponseDto.setStatsWin(team.getStatsWin());

        List<Long> eventTeamIds = new ArrayList<>();
        List<EventTeam> eventTeams = team.getEventTeams();
        for (EventTeam eventTeam: eventTeams){
            eventTeamIds.add(eventTeam.getId());
        }
        teamResponseDto.setEventTeamIds(eventTeamIds);
        return teamResponseDto;
    }
    public static List<TeamResponseDto> teamToTeamResponseDtoList (List<Team> teams){
        List<TeamResponseDto> teamResponseDtos = new ArrayList<>();

        for(Team team: teams){
            TeamResponseDto teamResponseDto = teamToTeamResponseDto(team);
            teamResponseDtos.add(teamResponseDto);
        }
        return teamResponseDtos;
    }
    //_______________________EVENT_TEAM_________________________________
    public static EventTeamResponseDto evenTeamToEventTeamResponseDto(EventTeam eventTeam){
        EventTeamResponseDto eventTeamResponseDto = new EventTeamResponseDto();

        eventTeamResponseDto.setId(eventTeam.getId());
        eventTeamResponseDto.setRegistrationDate(eventTeam.getRegistrationDate());

        eventTeamResponseDto.setEventId(eventTeam.getEvent().getId());
        eventTeamResponseDto.setTeamId(eventTeam.getTeam().getId());

        return eventTeamResponseDto;
    }
    public static List<EventTeamResponseDto> evenTeamToEventTeamResponseDtoList(List<EventTeam> eventTeamList){
        List<EventTeamResponseDto> eventTeamResponseDtos = new ArrayList<>();
        for(EventTeam eventTeam: eventTeamList){
            eventTeamResponseDtos.add(evenTeamToEventTeamResponseDto(eventTeam));
        }
        return eventTeamResponseDtos;
    }

}
