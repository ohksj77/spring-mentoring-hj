# spring-mentoring-hj

[사전 세팅](settings/setting.md)

### 목표 : 간단하게 DB를 활용한 API를 만들며 전체적인 흐름 파악

## 서비스 도메인
- Movie
    - 제목
    - 한줄 소개
    - 예매 가능 여부
- Ticket
    - 좌석 번호 (숫자)
    - 회원 닉네임
    - 예매 시각

## 서비스 요구사항
- 영화
    - 영화 생성
    - pk를 통한 조회
    - 제목으로 검색
    - 전체 검색
    - 예매 가능하도록 수정
    - 예매 불가능 하도록 수정
- 티켓
    - 예매
    - 예매 취소
    - 멤버 닉네임별 조회

## 사용 기술
- Java 17
- Spring MVC
- Spring Data JPA
- Gradle
- docker-compose
    - MySQL
- etc
    - Lombok
