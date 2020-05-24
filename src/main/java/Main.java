import org.springframework.context.support.GenericXmlApplicationContext;



public class Main {
    public static void main(String[] args){
        String[] ctxs = {"classpath:appCtx1.xml", "classpath:appCtx2.xml","classpath:appCtx3.xml"};
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(ctxs);

        StudentService studentService = ctx.getBean("studentService",StudentService.class);
        Student student1 = ctx.getBean("student1", Student.class);
        Student student2 = ctx.getBean("student2", Student.class);

        studentService.register(student1);
        studentService.register(student2);
    }
}
