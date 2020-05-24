import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
        Student student = ctx.getBean("student", Student.class);
        System.out.println(student.introMyself());
    }
}
