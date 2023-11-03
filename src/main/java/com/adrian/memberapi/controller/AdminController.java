package com.adrian.memberapi.controller;

import com.adrian.memberapi.dto.MemberFullDTO;
import com.adrian.memberapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/*test*/
@RestController
@RequestMapping("/admin/members")
public class AdminController {

    private final MemberService memberService;

    @Autowired
    public AdminController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberFullDTO>> getAllMembers(){
        List<MemberFullDTO> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberFullDTO> getMemberById(@PathVariable Long id){
        try{
            MemberFullDTO member = memberService.getMemberById(id);
            return ResponseEntity.ok(member);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MemberFullDTO> addMember(@RequestBody MemberFullDTO memberDTO){
        MemberFullDTO persistedMember = memberService.saveMember(memberDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(persistedMember.getId())
                .toUri();
        return ResponseEntity.created(location).body(persistedMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberFullDTO> updateMember(@PathVariable Long id, @RequestBody MemberFullDTO memberDTO){
        try{
            MemberFullDTO updatedMember = memberService.updateMember(id, memberDTO);
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
