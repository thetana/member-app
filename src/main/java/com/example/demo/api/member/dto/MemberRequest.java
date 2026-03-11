package com.example.demo.api.member.dto;

public record MemberRequest(
        String name,
        int age,
        String mbti) {
}
