package com.adrian.memberapi.controller;

import com.adrian.memberapi.dto.MemberDTO;
import com.adrian.memberapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin/members")
public class AdminController {

    private final MemberService memberService;

    @Autowired
    public AdminController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers(){
        List<MemberDTO> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Long id){
        try{
            MemberDTO member = memberService.getMemberById(id);
            return ResponseEntity.ok(member);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MemberDTO> addMember(@RequestBody MemberDTO memberDTO){
        MemberDTO persistedMember = memberService.saveMember(memberDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(persistedMember.getId())
                .toUri();
        return ResponseEntity.created(location).body(persistedMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO){
        try{
            MemberDTO updatedMember = memberService.updateMember(id, memberDTO);
            return ResponseEntity.ok(updatedMember);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
        try{
            memberService.deleteMember(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
