package com.example.demo.bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bet")
public class BetController {
    private final BetService betService;

    @Autowired
    public BetController(BetService betService) {
        this.betService = betService;
    }

    @Secured({"ADMIN", "USER"})
    @PostMapping
    public ResponseEntity<String> addBet(@RequestBody BetRequestDto betRequestDto) {
        betService.addBet(betRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created.");
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<BetResponseDto> getBet(@PathVariable final Long id) {
        BetResponseDto betResponseDto = betService.getBetById(id);
        return new ResponseEntity<>(betResponseDto, HttpStatus.OK);
    }*/
    @Secured("ADMIN")
    @GetMapping
    public ResponseEntity<List<BetResponseDto>> getBets() {
        List<BetResponseDto> betResponseDtos = betService.getBets();
        return new ResponseEntity<>(betResponseDtos, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> editBet(@PathVariable Long id, @RequestBody BetRequestDto betRequestDto){
        betService.editBet(id, betRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body("Bet edited.");
    }
}
