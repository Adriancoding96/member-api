package com.adrian.memberapi.service.implementation;

import com.adrian.memberapi.dto.AddressDTO;
import com.adrian.memberapi.dto.MemberDTO;
import com.adrian.memberapi.mapper.AddressMapper;
import com.adrian.memberapi.mapper.MemberMapper;
import com.adrian.memberapi.model.Address;
import com.adrian.memberapi.model.Member;
import com.adrian.memberapi.repository.AddressRepository;
import com.adrian.memberapi.repository.MemberRepository;
import com.adrian.memberapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final AddressRepository addressRepository;
    private final MemberMapper memberMapper;
    private final AddressMapper addressMapper;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, AddressRepository addressRepository,
                             MemberMapper memberMapper, AddressMapper addressMapper) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
        this.memberMapper = memberMapper;
        this.addressMapper = addressMapper;
    }



    @Override
    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(memberMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MemberDTO getMemberById(Long id) {
        Optional<Member> member = memberRepository.find(id);
        if(member.isEmpty()){
            throw new RuntimeException("Member not found");
        }
        return memberMapper.toDTO(member.get());
    }

    @Override
    @Transactional
    public MemberDTO saveMember(MemberDTO memberDTO) {
        AddressDTO addressDTO = memberDTO.getAddress();
        Address address = addressMapper.toEntity(addressDTO);
        Address persistedAddress = new Address();
        if(addressDTO != null && addressDTO.getId() == null){
            persistedAddress = addressRepository.save(address);
        }
        Member member = memberMapper.toEntity(memberDTO);
        member.setAddress(persistedAddress);
        Member savedMember = memberRepository.save(member);
        return memberMapper.toDTO(savedMember);
    }

    @Override
    @Transactional
    public MemberDTO updateMember(Long id, MemberDTO memberDTO) {
        Optional<Member> existingMember = memberRepository.find(id);
        if(existingMember.isEmpty()){
            //Replace with custom exception
            throw new RuntimeException("Member not found");
        }
        Member updatedMember = memberMapper.UpdateMemberFromDTO(existingMember.get(), memberDTO);
        updatedMember = memberRepository.save(updatedMember);
        return memberMapper.toDTO(updatedMember);
    }

    @Override
    @Transactional
    public void deleteMember(Long id) {
        memberRepository.delete(id);
    }
}
