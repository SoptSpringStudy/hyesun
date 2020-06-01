import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;


public class StudentRegisterService implements InitializingBean, DisposableBean {

    private StudentDao studentDao;

    @Autowired
    public StudentRegisterService(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public void register(Student student){
        studentDao.insert(student);
        System.out.println("등록되었습니다.");
    }
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("빈객체 소멸");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("빈객체 생성");
    }
}