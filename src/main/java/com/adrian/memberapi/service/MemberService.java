package com.adrian.memberapi.service;

import com.adrian.memberapi.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    List<MemberDTO> getAllMembers();
    MemberDTO getMemberById(Long id);
    MemberDTO saveMember(MemberDTO memberDTO);
    MemberDTO updateMember(Long id, MemberDTO memberDTO);
    void deleteMember(Long id);
}
