# spring-mentoring-hj

> 1회차: 2023.12.8, 2회차: 2023.12.13

- [사전 세팅](settings/setting.md)
- movie: 사용할 프로젝트
- movie-goal: 구현 완료시 프로젝트

### 목표 : 간단하게 DB를 활용한 API를 만들며 전체적인 흐름 파악

## 서비스 도메인
- Movie
    - 제목
    - 한줄 소개
    - 장르
    - 예매 가능 여부
- Ticket
    - 좌석 번호 (숫자)
    - 회원 닉네임
    - 예매 시각

## 서비스 요구사항
### 체크 표시는 스스로 해보기!

- 영화
    - 영화 생성
    - 단건 조회
    - 제목으로 검색
    - 장르별 검색
    - 전체 조회 v
    - 예매 가능하도록 수정
    - 예매 불가능 하도록 수정 v
    - 단건 삭제
- 티켓
    - 예매
    - 예매 취소 v
    - 멤버 닉네임별 조회 v

## 사용 기술
- Java 17
- Spring MVC
- Spring Data JPA
- Gradle
- docker-compose
    - MySQL
- etc
    - Lombok
