[ 0518 스프링 스터디 자료 ]

스프링 프레임워크는 주요기능으로 DI, AOP, MVC, JDBC 등을 제공한다.
스프링 프레임워크에서 제공하고 있는 모듈
Spring-core : di와 ioc를 제공
Spring-aop : aop 구현 기능 제공
Spring-jdbc : 데이터베이스를 쉽게 다룰 수 있는 기능 제공
Spring-tx : 트랜잭션 관련 기능 제공
Spring webmvc : model-view-controller 스프링 mvc구현 기능 제공
이러한 모듈을 사용하려면 개발 프로젝트에 xml 파일등을 이용해서 개발자가 직접 하면 된다.
스프링 컨테이너(IoC) : 스프링에서 객체를 생성하고 조립하는 컨테이너로, 컨테이너를 통해 생성된 객체를 빈이라고 부른다.
Maven을 이용해서 스프링 프로젝트를 생성하는 방법 ( maven: 빌드하는 툴 )
Pom.xml 작성 => 필요한 스프링 모듈 가져오기 위한 파일들, 메이븐 설정 파일로 메이븐은 라이브러리를 연결해주고, 빌드를 위한 플랫폼
폴더 구조 src/main/java -> 실제로 java를 사용해 기능 구현을 해나가는 곳 src/main/resources -> java 프로그래밍을 하면서 필요한 여러가지 파일들(스프링 설정 파일)
applicationContext.xml 파일은 스프링 컨테이너 역할이다.
DI(Dependency injection) -배터리 일체형 : 배터리가 떨어지면 장난감을 새로 구입해야 한다. -배터리 분리형 : 배터리가 떨어지면 배터리만 교체하면 된다. => 배터리가 의존 주입을 한다. 생성자에서 의존 주입을 해주고, set 함수에서도 의존 주입을 해준다.
스프링 DI 설정 방법 스프링 컨테이너 생성 및 빈(Bean) 객체 호출 과정

<프로젝트 설명>

-학생 관리 프로젝트 학생 번호, id, pw, 나이, 성별, 전공 학생 정보 select, update, delete 기능

**DI 형성은 어떻게? Service안에 DAO를 넣어준다. 예시로) Assembler 파일 안에 dao를 생성해서 service에 주입해주고 있다.

하지만, 실제 스프링에서는 Spring 설정 파일 안에 Constructor-arg 태그 안에 dao를 주입해주고 있다. => GeneralXMLApplicationContext을 통해 getBean을 해준다.

다양한 의존 객체 주입
생성자를 이용한 의존 객체 주입

Setter 를 이용한 의존 객체 주입 Property 태그를 이용한다. Name, value 속성을 넣어준다.
List 타입 의존 객체 주입 Property 태그를 이용하고, list 태그 안에 value 태그를 넣어주면 된다.
Map타입 객체 주입 Map 태그를 이용한다.
