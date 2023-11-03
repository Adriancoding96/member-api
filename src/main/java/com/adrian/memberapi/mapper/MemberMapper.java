package com.adrian.memberapi.mapper;

import com.adrian.memberapi.dto.AddressDTO;
import com.adrian.memberapi.dto.MemberDTO;
import com.adrian.memberapi.model.Address;
import com.adrian.memberapi.model.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public MemberDTO toDTO(Member member){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setFirstName(member.getFirstName());
        memberDTO.setLastName(member.getLastName());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setPhone(member.getPhone());
        memberDTO.setDateOfBirth(member.getDateOfBirth());
        if(member.getAddress() != null){
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setId(member.getAddress().getId());
            addressDTO.setStreet(member.getAddress().getStreet());
            addressDTO.setPostalCode(member.getAddress().getPostalCode());
            addressDTO.setCity(member.getAddress().getCity());
            memberDTO.setAddress(addressDTO);
        }
        return memberDTO;
    }

    public Member toEntity(MemberDTO memberDTO){
        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setFirstName(memberDTO.getFirstName());
        member.setLastName(memberDTO.getLastName());
        member.setEmail(memberDTO.getEmail());
        member.setPhone(memberDTO.getPhone());
        member.setDateOfBirth(memberDTO.getDateOfBirth());
        if(memberDTO.getAddress() != null){
            Address address = new Address();
            address.setId(memberDTO.getAddress().getId());
            address.setStreet(memberDTO.getAddress().getStreet());
            address.setPostalCode(memberDTO.getAddress().getPostalCode());
            address.setCity(memberDTO.getAddress().getCity());
            member.setAddress(address);
        }
        return member;
    }

    public Member UpdateMemberFromDTO(Member existingMember, MemberDTO memberDTO){
        existingMember.setFirstName(memberDTO.getFirstName());
        existingMember.setLastName(memberDTO.getLastName());
        existingMember.setEmail(memberDTO.getEmail());
        existingMember.setPhone(memberDTO.getPhone());
        existingMember.setDateOfBirth(memberDTO.getDateOfBirth());

        if(memberDTO.getAddress() != null){
            Address address = existingMember.getAddress();
            if (address == null) {
                address = new Address();
                existingMember.setAddress(address);
            }
            address.setStreet(memberDTO.getAddress().getStreet());
            address.setPostalCode(memberDTO.getAddress().getPostalCode());
            address.setCity(memberDTO.getAddress().getCity());
        }
        return existingMember;
    }
}
