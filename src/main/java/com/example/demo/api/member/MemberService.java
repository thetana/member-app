package com.example.demo.api.member;

import com.example.demo.api.member.dto.MemberRequest;
import com.example.demo.api.member.dto.MemberResponse;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class MemberService {
    private final MemberRepository memberRepository;

    private static final Duration PRESIGNED_URL_EXPIRATION = Duration.ofMinutes(10);

    private final S3Template s3Template;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

    @Transactional
    public MemberResponse saveMember(MemberRequest request) {
        Member member = new Member(
                request.name(),
                request.age(),
                request.mbti()
        );
        Member save = memberRepository.save(member);
        return MemberResponse.from(save);
    }

    public MemberResponse getMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("병건아, 이 유저는 없는거야"));
        return MemberResponse.from(member);
    }

    public String upload(MultipartFile file) {
        try {
            String key = "uploads/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
            s3Template.upload(bucket, key, file.getInputStream());
            return key;
        } catch (IOException e) {
            // 적절한 커스텀 예외로 바꾸고, GlobalExceptionHandler로 핸들링 필요
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }

    public URL getDownloadUrl(String key) {
        return s3Template.createSignedGetURL(bucket, key, PRESIGNED_URL_EXPIRATION);
    }
}
