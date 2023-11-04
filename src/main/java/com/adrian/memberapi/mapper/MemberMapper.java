package com.adrian.memberapi.mapper;

import com.adrian.memberapi.dto.*;
import com.adrian.memberapi.model.Address;
import com.adrian.memberapi.model.Member;
import com.adrian.memberapi.model.UserCredentials;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    /*NEED TO REDUCE DUPLICATED CODE*/

    public MemberFullDTO toFullDTO(Member member){
        MemberFullDTO memberDTO = new MemberFullDTO();
        memberDTO.setId(member.getId());
        memberDTO.setFirstName(member.getFirstName());
        memberDTO.setLastName(member.getLastName());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setPhone(member.getPhone());
        memberDTO.setDateOfBirth(member.getDateOfBirth());
        if(member.getUserCredentials() != null){
            UserCredentialsDTO userCredentialsDTO = new UserCredentialsDTO();
            userCredentialsDTO.setId(member.getUserCredentials().getId());
            userCredentialsDTO.setUsername(member.getUserCredentials().getUsername());
            memberDTO.setUserCredentials(userCredentialsDTO);
        }
        if(member.getAddress() != null){
            AddressFullDTO addressDTO = new AddressFullDTO();
            addressDTO.setId(member.getAddress().getId());
            addressDTO.setStreet(member.getAddress().getStreet());
            addressDTO.setPostalCode(member.getAddress().getPostalCode());
            addressDTO.setCity(member.getAddress().getCity());
            memberDTO.setAddress(addressDTO);
        }
        return memberDTO;
    }

    public MemberReducedDTO toReducedDTO(Member member){
        MemberReducedDTO memberDTO = new MemberReducedDTO();
        memberDTO.setFirstName(member.getFirstName());
        memberDTO.setLastName(member.getLastName());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setPhone(member.getPhone());
        if(member.getAddress() != null){
            AddressReducedDTO addressDTO = new AddressReducedDTO();
            addressDTO.setStreet(member.getAddress().getStreet());
            addressDTO.setPostalCode(member.getAddress().getPostalCode());
            addressDTO.setCity(member.getAddress().getCity());
            memberDTO.setAddress(addressDTO);
        }
        return memberDTO;
    }

    public Member toEntityFromFullDTO(MemberFullDTO memberDTO){
        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setFirstName(memberDTO.getFirstName());
        member.setLastName(memberDTO.getLastName());
        member.setEmail(memberDTO.getEmail());
        member.setPhone(memberDTO.getPhone());
        member.setDateOfBirth(memberDTO.getDateOfBirth());
        if(memberDTO.getUserCredentials() != null){
            UserCredentials userCredentials = new UserCredentials();
            userCredentials.setId(memberDTO.getUserCredentials().getId());
            userCredentials.setUsername(memberDTO.getUserCredentials().getUsername());
            member.setUserCredentials(userCredentials);
        }
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

    public Member UpdateMemberFromFullDTO(Member existingMember, MemberFullDTO memberDTO){
        existingMember.setFirstName(memberDTO.getFirstName());
        existingMember.setLastName(memberDTO.getLastName());
        existingMember.setEmail(memberDTO.getEmail());
        existingMember.setPhone(memberDTO.getPhone());
        existingMember.setDateOfBirth(memberDTO.getDateOfBirth());
        if(memberDTO.getUserCredentials() != null){
            existingMember.getUserCredentials().setId(memberDTO.getUserCredentials().getId());
            existingMember.getUserCredentials().setUsername(memberDTO.getUserCredentials().getUsername());
        }
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

    public Member UpdateMemberFromReducedDTO(Member existingMember, MemberReducedDTO memberDTO){
        existingMember.setFirstName(memberDTO.getFirstName());
        existingMember.setLastName(memberDTO.getLastName());
        existingMember.setEmail(memberDTO.getEmail());
        existingMember.setPhone(memberDTO.getPhone());

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
