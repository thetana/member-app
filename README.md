![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![mySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![aws](https://img.shields.io/badge/Amazon_AWS-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)
![DOCKER](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

# CH 4 클라우드_아키텍처 설계 & 배포
___
## LV 0
설정 완료된 AWS Budgets 화면
<img width="1197" height="401" alt="스크린샷 2026-03-10 113450" src="https://github.com/user-attachments/assets/789e6a85-a7a9-46ec-baca-364cf00e4f06" />

<details>
<summary><font color="#f08080 red">실습 후 요금 관리</font></summary>

🌟실습 끝났을 때 비용 안 나가게 하는 법 (중요)

실습 끝나면 이 2개만 삭제하세요

1️⃣ Amazon EC2 인스턴스 Terminate<br>
2️⃣ Amazon RDS DB 인스턴스 Delete

⚠️ AWS 실습에서 가장 많이 터지는 요금 사고

1️⃣ RDS 안 지우고 방치 (가장 흔함)<br>
2️⃣ NAT Gateway 생성 (시간당 요금)<br>
3️⃣ Elastic IP 미사용 상태
</details>

___
## LV 1
### 1. 설정 완료된 EC2의 퍼블릭 IP: `43.203.241.245`
### 2. [상태 검증 링크](http://43.203.241.245:8080/actuator/health)<br>
___
## LV 2
### 1. Actuator Info 엔드포인트 URL
[확인용 URL](http://43.203.241.245:8080/actuator/info)

<img width="448" height="186" alt="스크린샷 2026-03-11 171151" src="https://github.com/user-attachments/assets/77eaf3d0-92f2-4a3a-a5f7-fd782d88cf82" />

### 2. RDS 보안 그룹 스크린샷
<img width="1319" height="493" alt="스크린샷 2026-03-11 172927" src="https://github.com/user-attachments/assets/db5a3b65-4a8f-4c4a-84c1-16b54e632f3d" />
___
## LV 3
### 1. 발급받은 Presigned URL 1개와 해당 URL의 만료 시간
2026년 3월 18일 16시 55분에 Presigned URL 만료예정 <br>
[Presigned URL](https://cloud-health-taehoon-files.s3.ap-northeast-2.amazonaws.com/uploads/ee8e057f-2cd0-470f-af47-f3a0b4a7ecef_%EB%8F%84%EB%9D%BC.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20260311T025152Z&X-Amz-SignedHeaders=host&X-Amz-Credential=AKIA2OG7PDLV7BSASE4F%2F20260311%2Fap-northeast-2%2Fs3%2Faws4_request&X-Amz-Expires=604800&X-Amz-Signature=4ac510fc44dd881e7033917edcc78218e5baa3c9c621f21c30ff68e525c38cf4) <br>
___
## LV 4 - Docker & CI/CD 파이프라인 구축
### 1. Github Actions 성공 이미지

<img width="735" height="364" alt="스크린샷 2026-03-11 133933" src="https://github.com/user-attachments/assets/4fd68297-3625-47f1-b109-ee7045b83b87" />
<img width="727" height="531" alt="스크린샷 2026-03-11 133927" src="https://github.com/user-attachments/assets/f0c28628-30a7-42d6-a166-bd63c4aa538f" />

### 2. EC2 터미널 이미지

<img width="579" height="90" alt="스크린샷 2026-03-11 133918" src="https://github.com/user-attachments/assets/e769109d-253a-4216-afa2-de5444273ca2" />

___

## LV 5 - 고가용성 아키텍처와 보안 도메인 연결 (ALB + ASG + HTTPS)
### 1. HTTPS 적용된 도메인 URL
### [도메인 헬스체크](https://if7down8up.click/actuator/health)

<img width="563" height="218" alt="스크린샷 2026-03-11 235550" src="https://github.com/user-attachments/assets/40708757-cd9c-43b2-846a-393ec1f78b92" />

### 2. Target Group(대상 그룹) 이미지

<img width="1615" height="271" alt="스크린샷 2026-03-11 235642" src="https://github.com/user-attachments/assets/015d42a1-2ac7-4ad6-b321-d5c9a943cf1f" />

___
## LV 6 - 글로벌 성능 최적화 (CloudFront CDN)
### 1. CloudFront 이미지 URL
### [cdn](https://d1steumf39vx3r.cloudfront.net/1e2a2fd3-cd7f-49f7-8aaa-003ba7851f73_image%20(3).png)

<img width="804" height="392" alt="스크린샷 2026-03-11 235417" src="https://github.com/user-attachments/assets/8385d635-688c-4abb-ae7a-ab2f1d3d78da" />
