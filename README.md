# SpringWebProject
## [part1.스프링 개발 환경 구축(ex00)](https://github.com/rlarmsdn2999/SpringWebProject/tree/rlarmsdn2999/ex00)
### 01.개발을 위한 준비
##### 1.1.개발환경 설정
##### 1.2.스프링 프로젝트 생성
##### 1.3.Tomcat을 이용한 프로젝트 실행 확인
##### 1.4.Lombok 라이브러리 설치

### 02.스프링의 특징과 의존성 주입(DI) 
##### 2.2.의존성 주입 테스트(<context:component-scan>)
##### 2.3.스프링이 동작하면서 생기는 일

### 03.스프링과 Oracle Database연동
##### 3.1.프로젝트의 JDBC연결
##### 3.2.커넥션 풀 설정

### 04.MyBatis와 스프링 연동
##### 4.2.스프링과 연동 처리
##### 4.3.log4jdbc-log4j2 설정

## [part2.스프링 MVC 설정(ex01)](https://github.com/rlarmsdn2999/SpringWebProject/tree/rlarmsdn2999/ex01)
### 01.스프링 MVC 기본 구조
##### 1.1.스프링 MVC 프로젝트의 내부 구조
##### 1.2.예제 프로젝트의 로딩 구조
##### 1.3.스프링 MVC의 기본사상
##### 1.4.모델2와 스프링 MVC

### 02.스프링 MVC의 Controller
##### 2.1.@Controller,@RequestMapping
##### 2.2.@RequestMapping의 변화
##### 2.3.Controller의 파라미터 수집
##### 2.4.Model이라는 데이터 전달자
##### 2.5.Controller의 리턴 타입

## [part3.기본적인 웹 게시물 관리(ex02)](https://github.com/rlarmsdn2999/SpringWebProject/tree/rlarmsdn2999/ex02)
### 01.스프링 MVC 프로젝트의 기본 구성
##### 1.1.프로젝트를 위한 요구사항
##### 1.2.예제 프로젝트 구성
##### 1.3.데이터베이스 관련 설정 및 테스트

### 02.영속/비즈니스 계층의 CRUD 구현
##### 2.1.영속 계층의 구현 준비
##### 2.2.영속 영역의 CRUD 구현

### 03.비즈니스 계층
##### 3.1.비즈니스 계층의 설정
##### 3.2.비즈니스 설정의 구현과 테스트

### 04.프리젠테이션(웹) 계층의 CRUD구현
##### 4.1.Controller의 작성
##### 4.2.BoardController의 작성

### 05.화면 처리
##### 5.1.목록 페이지 작업과 includes
##### 5.2.목록 화면 처리
##### 5.3.등록 입력 페이지와 등록 처리
##### 5.4.조회 페이지와 이동
##### 5.5.게시물의 수정/삭제 처리

### 06.오라클 데이터베이스 페이징 처리
##### 6.1.order by의 문제
##### 6.2.order by 보다는 인덱스
##### 6.3.인덱스를 이용하는 정렬
##### 6.4.ROWNUM과 인라인뷰

### 07.Mybatis와 스프링에서 페이징 처리
##### 7.1.Mybatis처리와 테스트
##### 7.2.BoardController와 BoardServide수정

### 08.검색 처리
##### 8.1.검색 기능과 SQL
##### 8.2.MyBatis의 동적 SQL
##### 8.3.검색 조건 처리를 위한 Criteria의 변화
##### 8.4.화면에서 검색 조건 처리

## [part4.REST방식과 AJAX를 이용하는 댓글 처리(ex03)](https://github.com/rlarmsdn2999/SpringWebProject/tree/rlarmsdn2999/ex03)
### 01.REST방식으로 전환
##### 1.1.@RestController
##### 1.2.@RestController의 반환 타입
##### 1.3.@RestController에서 파라미터
##### 1.4.REST방식의 테스트
##### 1.5.다양한 전송방식

### 02.Ajax 댓글 처리
##### 2.1.프로젝트의 구성
##### 2.2.댓글 처리를 위한 영속 영역
##### 2.3.서비스 영역과 Controller처리
##### 2.4.JavaScript 준비
##### 2.5.이벤트 처리와 HTML처리
##### 2.6.댓글의 페이징 처리
##### 2.7.댓글 페이지의 화면 처리

## [나만의 게시판(myboard)](https://github.com/rlarmsdn2999/SpringWebProject/tree/rlarmsdn2999/myboard)