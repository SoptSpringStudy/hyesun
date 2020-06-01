import java.util.HashMap;
import java.util.Map;

public class StudentDao {
    private int key=0;
    private Map<Integer,Object> map = new HashMap<Integer, Object>();

    public void insert(Student student){
        map.put(key,student);
        key++;
        map.forEach((key,value) -> System.out.println("key: "+key+", name: "+((Student)value).name+", age: "+((Student)value).age+", soptDept: "+((Student)value).soptDept));
    }
    public void select(int stuNum){
        Student student = (Student)map.get(stuNum);
        System.out.println(student.name+", "+student.age+", "+student.soptDept);
    }
}
