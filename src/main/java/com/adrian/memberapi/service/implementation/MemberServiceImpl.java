package com.adrian.memberapi.service.implementation;

import com.adrian.memberapi.dto.AddressFullDTO;
import com.adrian.memberapi.dto.MemberFullDTO;
import com.adrian.memberapi.dto.MemberReducedDTO;
import com.adrian.memberapi.dto.UserCredentialsFullDTO;
import com.adrian.memberapi.exception.EntityNotFoundException;
import com.adrian.memberapi.exception.NotFoundException;
import com.adrian.memberapi.mapper.AddressMapper;
import com.adrian.memberapi.mapper.MemberMapper;
import com.adrian.memberapi.mapper.UserCredentialsMapper;
import com.adrian.memberapi.model.Address;
import com.adrian.memberapi.model.Member;
import com.adrian.memberapi.model.UserCredentials;
import com.adrian.memberapi.repository.AddressRepository;
import com.adrian.memberapi.repository.MemberRepository;
import com.adrian.memberapi.repository.UserCredentialsRepository;
import com.adrian.memberapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final AddressRepository addressRepository;
    private final UserCredentialsRepository userCredentialsRepository;
    private final MemberMapper memberMapper;
    private final AddressMapper addressMapper;
    private final UserCredentialsMapper userCredentialsMapper;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, AddressRepository addressRepository, UserCredentialsRepository userCredentialsRepository,
                             MemberMapper memberMapper, AddressMapper addressMapper, UserCredentialsMapper userCredentialsMapper) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
        this.userCredentialsRepository = userCredentialsRepository;
        this.memberMapper = memberMapper;
        this.addressMapper = addressMapper;
        this.userCredentialsMapper = userCredentialsMapper;
    }

    @Override
    public List<MemberFullDTO> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(memberMapper::toFullDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MemberReducedDTO> getAllMembersLimitedInfo() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(memberMapper::toReducedDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MemberFullDTO getMemberById(Long id) {
        Optional<Member> member = memberRepository.find(id);
        if(member.isEmpty()){
            throw new NotFoundException("Member with id: " + id + " not found");
        }
        return memberMapper.toFullDTO(member.get());
    }

    @Override
    @Transactional
    public MemberFullDTO saveMember(MemberFullDTO memberDTO) {
        AddressFullDTO addressDTO = memberDTO.getAddress();
        Address address = addressMapper.toEntity(addressDTO);
        Address persistedAddress = new Address();
        if(addressDTO.getId() == null){
            persistedAddress = addressRepository.save(address);
        }
        UserCredentialsFullDTO userCredentialsDTO = memberDTO.getUserCredentials();
        UserCredentials userCredentials = userCredentialsMapper.toEntity(userCredentialsDTO);
        UserCredentials persistedUserCredentials = new UserCredentials();
        if(userCredentialsDTO.getId() == null){
            persistedUserCredentials = userCredentialsRepository.save(userCredentials);
        }
        Member member = memberMapper.toEntityFromFullDTO(memberDTO);
        member.setAddress(persistedAddress);
        member.setUserCredentials(persistedUserCredentials);
        Member savedMember = memberRepository.save(member);
        return memberMapper.toFullDTO(savedMember);
    }

    @Override
    @Transactional
    public MemberFullDTO updateMember(Long id, MemberFullDTO memberDTO) {
        Optional<Member> existingMember = memberRepository.find(id);
        if(existingMember.isEmpty()){
            throw new NotFoundException("Member with id: " + id + " not found");
        }
        Member updatedMember = memberMapper.UpdateMemberFromFullDTO(existingMember.get(), memberDTO);
        updatedMember = memberRepository.save(updatedMember);
        return memberMapper.toFullDTO(updatedMember);
    }

    @Override
    @Transactional
    public void deleteMember(Long id) {
        System.out.println(id);
        Optional<Member> member = memberRepository.find(id);
        if(member.isEmpty()){
            throw new EntityNotFoundException("member with id: " + " not found");
        }
        memberRepository.delete(id);
    }
}
