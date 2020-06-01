import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        String[] name = {"hs","mj","ks"};
        int[] age = {11,14,16};
        String[] soptDept = {"android","server","server"};

        String[] ctxs = {"classpath:appCtx1.xml"};
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(ctxs);

        StudentRegisterService studentRegisterService = ctx.getBean("studentRegisterService", StudentRegisterService.class);
        for(int i=0; i<name.length; i++){
            studentRegisterService.register(new Student(name[i],age[i],soptDept[i]));
        }

        StudentSearchService studentSearchService = ctx.getBean("studentSearchService",StudentSearchService.class);
        System.out.println("찾을 번호를 입력해주세요 : ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        studentSearchService.searchStudent(num);

        ctx.close();
    }
}
