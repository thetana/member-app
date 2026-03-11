package com.example.demo.api.member;

import com.example.demo.api.member.dto.MemberRequest;
import com.example.demo.api.member.dto.MemberResponse;
import com.example.demo.api.member.dto.FileDownloadUrlResponse;
import com.example.demo.api.member.dto.FileUploadResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public MemberResponse save(@RequestBody MemberRequest request) {
        return memberService.saveMember(request);
    }

    @GetMapping("/{id}")
    public MemberResponse get(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PostMapping("/{id}/profile-image")
    public ResponseEntity<FileUploadResponse> upload(@RequestParam("file") MultipartFile file) {
        String key = memberService.upload(file);
        return ResponseEntity.ok(new FileUploadResponse(key));
    }

    @GetMapping("/{id}/profile-image")
    public ResponseEntity<FileDownloadUrlResponse> getDownloadUrl(@RequestParam String key) {
        URL url = memberService.getDownloadUrl(key);
        return ResponseEntity.ok(new FileDownloadUrlResponse(url.toString()));
    }
}
