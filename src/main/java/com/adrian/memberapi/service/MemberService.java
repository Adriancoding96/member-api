package com.adrian.memberapi.service;

import com.adrian.memberapi.dto.MemberFullDTO;
import com.adrian.memberapi.dto.MemberReducedDTO;

import java.util.List;

public interface MemberService {
    List<MemberFullDTO> getAllMembers();
    List<MemberReducedDTO> getAllMembersLimitedInfo();
    MemberFullDTO getMemberById(Long id);
    MemberFullDTO saveMember(MemberFullDTO memberDTO);
    MemberFullDTO updateMember(Long id, MemberFullDTO memberDTO);
    void deleteMember(Long id);
}
