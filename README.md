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
[Presigned URL](https://camp-health-if7down8up-files.s3.ap-northeast-2.amazonaws.com/uploads/e658d5b6-620e-4ee6-96ba-f63cfb17a3b4_image%20%283%29.png?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEI%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaDmFwLW5vcnRoZWFzdC0yIkcwRQIgWLD19JgGA64B%2B3VyVR5xm3SrQolwe90YHWTar%2FOEAt4CIQD0WXLGrSvFd1LXSgHpHguqKkkwYfX4vZdOqV1gRlHXCCrKBQhYEAAaDDQxNjE3MDYxNDkxMCIM0OSccZ53tJZj2401KqcFAPQq1lzR6suaZKRmRKnNAd%2Fqpi3HM1dgKsqZioiQ%2BCjPJbwK%2BOyw3GP6U9VVGgsF3lZqQnSaniDw173YN9TmDYTTL4TljXxzk%2Fp9Ox2O4SsuxlCCdWXVYRBoRM0oUB6Ef5r%2F7fUF78tAymxasfnosF0cKGjXMTRQ8KSC%2FY7U3m3IxWZfJnXMrV%2Fn3Mp5trjBWiPMwE81zhi54eAjHzo2PTYdLoJYnQNGZq5T2XzSSzjZ6LXPUs2U3vnR%2BladUS5CHHa9maBo2BA%2Fix%2BoQCe6IcaemV3ogFr56VaUjuqPY8AUF7nIiwvuvIw8bEZecNWXFDH1%2B7Cobz9PA0Daa8lqvN%2B%2BWbqku0yvWtyjTytCkz6cefJoKCmWvVaO6Sub5DLDUlOtvhzAfop1KBoG9VoscoVXXZvaKdPNcZuuwWdYeowm%2B4UvW7rRwfKMf0FYFrv3161CYmNSkp3z%2BmlS1Dy%2BVG1RqJA6Ev2hfDfrKn2rd6JG6oJq%2F1JNaYjXPW0wdXvUHSn1%2Bl3A1fUG1Fb%2FrxcHChB9qHk7FWWN8H%2B5%2BQ%2B8FmLwJJlCzhavBQkvpRYeTZfM4kp2OmdkAA9leD9c1VaPeU71EQi2078PotmujQWNPPicHo5oxmi1x9lACqL3KZbFMrAZvg06%2F%2BAGqzsL5l2Jmo0sdcs%2BDOfZleTIFC8o4UXxpCri%2BFEs7XM5t%2BfW6pFk2D3Gp7BBEarAATmKMa4gvN%2FQ2gvlOLGgqG0YaH%2Fov3tA%2FXdUiex6Gvul8AR%2B7%2Bnfn56DN3DgO2YoCbwFb9WpxrrIJ0%2BVTgmGY0cVIPE4czIVq9%2FwWdat8sCbOs4fCQBghUOIYGku402%2F1bo%2BzEwo9wXfhtlqCXJbY0o8a9CC%2By%2BGZXpkC0LPTQnYdWWpHKJ%2F2Dy6bMZ%2BjTDCpMTNBjqxAQaF3zSD%2FdhI1zEqMa9MXvOiZxM2l3S7dnMyC4ffTZCrHYhx2qO64cbNubfHKhi5zzeSxJEcTkjmrlXyJqaFbCAEfU6zmU6cSsyRLuJZKrljrcrjoAFdOi%2FYIbFMy3DLfDKMRgphF2ni94aY1gxVlhNgnXBRP5wo5eyfVBdRpSdg5iQ6Rsx%2BKnbOauJ3oNrJk824aTb2qPUePcqX%2BFPzDeRJwbgVb7ICgHmFfBZuQnm2NQ%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20260311T075544Z&X-Amz-SignedHeaders=host&X-Amz-Credential=ASIAWBZNTUB7DNEEW4GU%2F20260311%2Fap-northeast-2%2Fs3%2Faws4_request&X-Amz-Expires=604800&X-Amz-Signature=9003fc6dd288393c2ad419624c4c28c9f1a89f24fb2e4f1a76b36f17f170e7b2)
___
