# [ 0518 스프링 스터디 자료 ]
*	스프링 프레임워크는 주요기능으로 DI, AOP, MVC, JDBC 등을 제공한다.
*	스프링 프레임워크에서 제공하고 있는 모듈
1)	Spring-core : di와 ioc를 제공
2)	Spring-aop : aop 구현 기능 제공
3)	Spring-jdbc : 데이터베이스를 쉽게 다룰 수 있는 기능 제공
4)	Spring-tx : 트랜잭션 관련 기능 제공
5)	Spring webmvc : model-view-controller 스프링 mvc구현 기능 제공
*	이러한 모듈을 사용하려면 개발 프로젝트에 xml 파일등을 이용해서 개발자가 직접 하면 된다.
*	스프링 컨테이너(IoC) : 스프링에서 객체를 생성하고 조립하는 컨테이너로, 컨테이너를 통해 생성된 객체를 빈이라고 부른다.
*	Maven을 이용해서 스프링 프로젝트를 생성하는 방법 ( maven: 빌드하는 툴 )
*	Pom.xml 작성 => 필요한 스프링 모듈 가져오기 위한 파일들, 메이븐 설정 파일로 메이븐은 라이브러리를 연결해주고, 빌드를 위한 플랫폼
*	폴더 구조

src/main/java -> 실제로 java를 사용해 기능 구현을 해나가는 곳

src/main/resources -> java 프로그래밍을 하면서 필요한 여러가지 파일들(스프링 설정 파일)
*	applicationContext.xml 파일은 스프링 컨테이너 역할이다.
*	DI(Dependency injection)

-배터리 일체형 : 배터리가 떨어지면 장난감을 새로 구입해야 한다.

-배터리 분리형 : 배터리가 떨어지면 배터리만 교체하면 된다.

=> 배터리가 의존 주입을 한다.

생성자에서 의존 주입을 해주고, set 함수에서도 의존 주입을 해준다.

*	스프링 DI 설정 방법
스프링 컨테이너 생성 및 빈(Bean) 객체 호출 과정
 
<프로젝트 설명>

-학생 관리 프로젝트
학생 번호, id, pw, 나이, 성별, 전공

학생 정보 select, update, delete 기능

*DI 형성은 어떻게?

Service안에 DAO를 넣어준다.

예시로) Assembler 파일 안에 dao를 생성해서 service에 주입해주고 있다.

하지만, 실제 스프링에서는 Spring 설정 파일 안에 Constructor-arg 태그 안에 dao를 주입해주고 있다. => GeneralXMLApplicationContext을 통해 getBean을 해준다.

*	다양한 의존 객체 주입
1)	생성자를 이용한 의존 객체 주입
2)	Setter 를 이용한 의존 객체 주입
Property 태그를 이용한다. Name, value 속성을 넣어준다.
3)	List 타입 의존 객체 주입
Property 태그를 이용하고, list 태그 안에 value 태그를 넣어주면 된다.
4)	Map타입 객체 주입
Map 태그를 이용한다.


# [ 0525 스프링 스터디 ]
*	스프링 설정 파일 분리
applicationContext.xml -> app1.xml, app2.xml, app3.xml 분리

App1.xml -> dao, service 설정

App2.xml -> bean 클래스 설정

App3.xml -> bean 클래스 설정
*	분리된 파일 -> 배열로 classpath 설정 , import로 넣어주기 
*	빈(Bean)의 범위

-싱글톤(singleton) : 스프링 컨테이너에서 생성된 빈 객체의 경우 동일한 타입에 대해서는 기본적으로 한 개만 생성이 되며, getBean() 메소드로 호출될 때 동일한 객체가 반환된다.

-프로토 타입 : 싱글톤 범위와 반대의 개념도 있는데 이를 프로토 타입 범위라고 한다. 프로토타입의 경우 개발자는 별도로 설정을 해줘야 하는데, 스프링 설정 파일에서 빈 객체를 정의 할 때 scope속성을 명시해 주면 된다.

Scope = “prototype” 을 설정하면 다른 객체로 만들어진다. 똑같은 객체를 두번 만들어주면 각각 다른 객체로 만들어진다.

*	의존 객체 자동 주입
*	스프링 설정 파일에서 의존 객체를 주입할 때 <constructor-org> 또는 <property> 태그로 의존 대상 객체를 명시하지 않아도 스프링 컨테이너가 자동으로 필요한 의존 대상 객체를 찾아서 의존 대상 객체가 필요한 객체에 주입해 주는 기능이다. 구현 방법은 @Autowired와 @Resource 어노테이션을 이용해서 쉽게 구현할 수 있다.  

1)	@Autowired
주입하려고 하는 객체의 타입이 일치하는 객체를 자동으로 주입한다.
Ex) 단어를 검색을 하는 프로젝트
<context:annotation-config/> => 어노테이션 사용을 위해 추가

2)	@Resource
주입하려고 하는 객체의 이름이 일치하는 객체를 자동으로 주입한다.
But, 생성자에서는 쓸 수 없음.

*	의존 객체 선택
동일한 객체가 2개 이상인 경우 스프링 컨테이너는 자동 주입 대상 객체를 판단하지 못해서 Exception을 발생시킨다.
=>	해결방법 : @Qualifier 를 이용!
Ex) <bean id=”worddao1” class=”worddao” /> <bean id=”worddao2” class=”worddao” />
<bean id=”worddao3” class=”worddao” /> 
동일한 3개의 빈 객체
<qualifier value=””/> 를 이용해서 해결

*	의존객체 자동 주입 체크
@Autowired(required= false) //거의 쓰지 않음

*	@Inject 어노테이션

@autowired 와 거의 비슷하게 이용해서 의존 객체를 자동으로 주입을 할 수 있다.

차이점: required 속성을 지원하지 않는다.

* Inject 사용할 시 동일한 객체가 여러개 사용될 경우

@Inject
@Named(value=””)
이렇게 많이 쓰인다.

=> Autowired 가 더 많이 쓰인다.

# [0601 스프링 스터디]
*	스프링 컨테이너 생명주기
1)	GenericXmlApplicationContext를 이용한 스프링 컨테이너 생성(생성 시점)
2)	getBean()을 이용한 빈 객체 이용
3)	close()을 이용한 스프링 컨테이너 종료 (소멸 시점)
*	빈 객체의 생명주기는 스프링 컨테이너의 생명주기와 같이 한다.
*	빈 객체가 생성이 되고 소멸이 되는 시점에 특정한 작업을 할 수 있다.
1)	Interface를 이용한 방법
InitializingBean, DisposableBean interface 참조
2)	Init-method, destroyMethod<br/>
Bean 속성에 작성
* 어노테이션을 이용한 스프링 설정
* Xml 파일을 java 파일로 변경
** @configuration 어노테이션 이용(스프링 컨테이너로써 명칭을 해줄 때 쓰임), @Bean 어노테이션 이용(bean 객체를 생성할 때 쓰임)
GenericXmlApplicationContext 대신 AnnotationConfigApplicationContext 클래스를 이용
* Java 파일 분리
* 왜? 한 파일에 모두 작성 시 유지보수가 힘들다<br/>
Dao, Service, Database, Util 등으로 보통 분리
** 파일 분리 시 다른 파일에서 참조하고 싶은 메서드가 있을 시 -> @Autowired 어노테이션을 통해 참조
*	분리된 파일을 어떻게 불러올까? 
1)	배열 타입으로 나열해준다.
2)	@Import 어노테이션<br/>
1번 클래스에서 @Import({2번 클래스, 3번클래스}) 를 써준다.

