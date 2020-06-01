import org.springframework.beans.factory.annotation.Autowired;

public class StudentSearchService {
    private StudentDao studentDao;
    @Autowired
    public StudentSearchService(StudentDao studentDao){
        this.studentDao = studentDao;
    }
    public void searchStudent(int stuNum){
        studentDao.select(stuNum);
    }
}
