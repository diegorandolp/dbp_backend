package com.example.demo.eventTeam;

import java.util.Date;

public class EventTeamResponseDto {
    private Long id;
    private Date registrationDate;
    private Long eventId;
    private Long teamId;
    public EventTeamResponseDto(){}

    public EventTeamResponseDto(Long id, Date registrationDate, Long eventId, Long teamId) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.eventId = eventId;
        this.teamId = teamId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
