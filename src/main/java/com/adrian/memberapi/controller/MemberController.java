package com.adrian.memberapi.controller;

import com.adrian.memberapi.dto.MemberFullDTO;
import com.adrian.memberapi.dto.MemberReducedDTO;
import com.adrian.memberapi.service.AuthorizationService;
import com.adrian.memberapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/mypages/members")
@PreAuthorize("hasRole('USER')")
public class MemberController {

    private final MemberService memberService;

    private final AuthorizationService authorizationService;

    @Autowired
    public MemberController(MemberService memberService, AuthorizationService authorizationService) {
        this.memberService = memberService;
        this.authorizationService = authorizationService;
    }

    @GetMapping
    public ResponseEntity<List<MemberReducedDTO>> getAllMembersLimitedInfo(){
        List<MemberReducedDTO> members = memberService.getAllMembersLimitedInfo();
        return ResponseEntity.ok(members);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberFullDTO> updateMember(@PathVariable Long id, @RequestBody MemberFullDTO memberDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new RuntimeException("Authentication is null");
        }
        if(!authentication.isAuthenticated()){
            throw new RuntimeException("Not Authenticated");
        }
        String username = authentication.getName();
        System.out.println(username);
        boolean canUpdate = authorizationService.canUpdateMember(id, username);
        if(!canUpdate){
            throw new RuntimeException("Not Authorized!");
        }
        MemberFullDTO updatedMember = memberService.updateMember(id, memberDTO);
        return ResponseEntity.ok(updatedMember);
    }
}
