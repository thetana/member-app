package com.example.demo.api.member.dto;

import com.example.demo.api.member.Member;
import lombok.Builder;

@Builder
public record MemberResponse(
        Long id,
        String name,
        int age,
        String mbti) {

    public static MemberResponse from(Member member){
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .age(member.getAge())
                .mbti(member.getMbti())
                .build();
    }
}
