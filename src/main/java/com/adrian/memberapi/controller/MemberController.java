package com.adrian.memberapi.controller;

import com.adrian.memberapi.dto.MemberFullDTO;
import com.adrian.memberapi.dto.MemberReducedDTO;
import com.adrian.memberapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/mypages/members")
@PreAuthorize("hasRole('USER')")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberReducedDTO>> getAllMembersLimitedInfo(){
        List<MemberReducedDTO> members = memberService.getAllMembersLimitedInfo();
        return ResponseEntity.ok(members);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberFullDTO> updateMember(@PathVariable Long id, @RequestBody MemberFullDTO memberDTO){
        if(!Objects.equals(memberDTO.getId(), id)){
            throw new RuntimeException("Incorrect id");
        }
        MemberFullDTO updatedMember = memberService.updateMember(id, memberDTO);
        return ResponseEntity.ok(updatedMember);
    }
}
