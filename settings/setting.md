## 미리 설치해야하는 프로그램
- docker
- Postman
- Java 17 버전의 jdk
- IntelliJ

## 프로젝트 세팅
1. movie 프로젝트를 인텔리제이에서 열어준다.
2. `.env.template` 파일 내용 및 파일명 `.env`로 수정한다.
3. EnvFile 플러그인을 세팅한다. -> 이미지들을 참고한다.
4. 빌드 방법을 세팅한다. -> 이미지를 참고한다.
5. annotation 프로세싱을 세팅한다. -> 이미지를 참고한다.

## Docker 명령어
- movie 디렉터리에서 실행해야 합니다.

실행시
```
docker-compose up
```

종료시
```
docker-compose down
```

## Reference
- [https://start.spring.io](https://start.spring.io)
- [https://www.oracle.com/kr/java/technologies/downloads/#jdk17-mac](https://www.oracle.com/kr/java/technologies/downloads/#jdk17-mac)
