package com.polstat.perpustakaan.controller;

import com.polstat.perpustakaan.entity.Member;
import com.polstat.perpustakaan.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class MemberGraphqlController {

    @Autowired
    private MemberRepository memberRepository;

    @QueryMapping
    public List<Member> members() {
        Iterable<Member> iterableMembers = memberRepository.findAll();
        return StreamSupport.stream(iterableMembers.spliterator(), false)
                .collect(Collectors.toList());
    }

    @QueryMapping
    public Member memberById(@Argument Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if (optionalMember.isPresent()) {
            return optionalMember.get();
        } else {
            throw new IllegalArgumentException("Member dengan id " + id + " tidak ditemukan");
        }
    }


    @MutationMapping
    public Member createMember(@Argument String memberID,
                               @Argument String name,
                               @Argument String address,
                               @Argument String phoneNumber) {

        Member newMember = Member.builder()
                .memberID(memberID)
                .name(name)
                .address(address)
                .phoneNumber(phoneNumber)
                .build();

        return memberRepository.save(newMember);
    }

    @MutationMapping
    public Member updateMember(@Argument Long id,
                               @Argument String memberID,
                               @Argument String name,
                               @Argument String address,
                               @Argument String phoneNumber) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if (optionalMember.isPresent()) {
            Member memberToUpdate = optionalMember.get();

            memberToUpdate.setMemberID(memberID);
            memberToUpdate.setName(name);
            memberToUpdate.setAddress(address);
            memberToUpdate.setPhoneNumber(phoneNumber);

            return memberRepository.save(memberToUpdate);
        } else {
            throw new IllegalArgumentException("Member dengan id " + id + " tidak ditemukan");
        }
    }

    @MutationMapping
    public void deleteMember(@Argument Long id) {
        memberRepository.deleteById(id);
    }
}