package com.livenow.week1.controller;

import com.livenow.week1.controller.dto.MemberSaveRequestDto;
import com.livenow.week1.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity saveMember(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
        return new ResponseEntity(memberService.save(memberSaveRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public List<ResponseEntity> findMembers() {
        return memberService.findAll()
                .stream()
                .map(member -> new ResponseEntity(member, HttpStatus.OK))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity findMember(@PathVariable Long id) {
        return new ResponseEntity(memberService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMember(@PathVariable Long id) {
        return new ResponseEntity(memberService.delete(id), HttpStatus.OK);
    }
}
