package com.example.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/event")

public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @Secured({"ADMIN"})
    @PostMapping
    public ResponseEntity<String> addEvent(@RequestBody EventRequestDto eventRequestDto) {
        eventService.addEvent(eventRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Event created.");
    }
    @Secured({"ADMIN", "USER"})
    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEvent(@PathVariable Long id) {
        EventResponseDto eventResponseDto = eventService.getEventById(id);
        if (eventResponseDto != null) {
            return new ResponseEntity<>(eventResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getall")
    public ResponseEntity<List<EventResponseDto>> getEvents() {
        List<EventResponseDto> eventResponseDtos = eventService.getEvents();
        return new ResponseEntity<>(eventResponseDtos, HttpStatus.OK);
    }
    @Secured({"ADMIN"})
    @PatchMapping("/{id}")
    public ResponseEntity<String> editEvent(@PathVariable Long id, @RequestBody EventRequestDto eventRequestDto){
        try{
            eventService.editEvent(id, eventRequestDto);
            return new ResponseEntity<>("Event edited", HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>("Hubo un error: "+ e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
}
