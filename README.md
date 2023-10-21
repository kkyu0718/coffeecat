## 📌 Tech Stack
| 분류 | Stack |
| --- | --- |
| Archictecture | Spring Web MVC, Spring Cloud Gateway |
| Language | Java 17 |
| Framework | Spring Boot |
| Database/ORM | MySQL, Redis, Spring Data JPA |
| CI/CD | (로컬 환경 진행 중) ~~github action, kubernetes~~ |
## 💻 System Architecture
![image](https://github.com/kkyu0718/coffeecat/assets/80209277/53374947-e272-47ee-8764-c90fbf59bd0d)
**아키텍처 설명**

- **멀티 모듈 설계** : `boot` 는 서버로 띄워져 있으며 `data` 는 필요한 boot 서버에 의존성 주입을 하는 방식을 사용하였습니다. 원래는 data 모듈까지 서버로 만들고자 하였으나 `kafka` 구성에 대해 공부할 시간이 필요하다고 판단하여 1차적으로 의존성 주입 방법을 택하였습니다. 추후에 kafka 를 학습한 후 `이벤트 기반 pub-sub 모델`로 개선하고자 합니다.
- **비동기 게이트웨이 - blocking boot 서버 구조** : `Spring Cloud Gateway` 의 netty 서버 라우팅을 이용하며 `Spring Web MVC` (동기 서버) 를 사용한다는 것은 성능에 좋지 못함을 인지하고 있습니다. 다만 개발의 속도를 고려하여 좀 더 익숙한 web mvc를 사용하였으며 추후에 `Spring Webflux` 로 바꾸는 작업을 진행하고자 합니다.
- **Gateway 선택** : 다른 오픈소스 gateway 의 도입도 고려하였으나 먼저 `kubernetes` 에 대한 공부가 필요하다는 점과 커스텀을 위해서는 java 코드가 편할 것을 생각하여 `Spring Cloud Gateway`를 선택하게 되었습니다.
![image](https://github.com/kkyu0718/coffeecat/assets/80209277/f48b56dc-6520-46aa-b609-79dbda28559e)
**개선 예정 아키텍처**    
- `kafka` 도입 통해 event pub sub 모델로 개선
- non-blocking 한 서버인 `Spring Webflux` 로 대체
- gateway 오픈 소스 중 다른 것으로 대체 예정
- `kubernetes` 통한 배포 예정

</div>
</details>

## 💫 ERD
![image](https://github.com/kkyu0718/coffeecat/assets/80209277/5039fd03-6195-4945-8465-cd92adfbb7af)
