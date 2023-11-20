package com.example.demo.eventTeam;

import java.util.Date;

public class EventTeamRequestDto {
    private Date registrationDate;
    private Long eventId;
    private Long teamId;
    public EventTeamRequestDto(){}
    public EventTeamRequestDto(Date registrationDate, Long eventId, Long teamId) {
        this.registrationDate = registrationDate;
        this.eventId = eventId;
        this.teamId = teamId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
