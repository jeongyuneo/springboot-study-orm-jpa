package com.livenow.week1.controller;

import com.livenow.week1.controller.dto.MemberAddRequestDto;
import com.livenow.week1.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity save(@RequestParam String name) {
        return new ResponseEntity(teamService.save(name), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity addMember(@RequestBody MemberAddRequestDto memberAddRequestDto) {
        return new ResponseEntity(teamService.addMember(memberAddRequestDto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity removeMember(@PathVariable Long id) {
        return new ResponseEntity(teamService.deleteMember(id), HttpStatus.OK);
    }
}
