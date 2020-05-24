import java.util.HashMap;
import java.util.Map;

public class StudentDao {
    private int key=0;
    private Map<String,Object> map = new HashMap<String,Object>();

    public void insert(Student student){
        map.put(Integer.toString(key),student);
        key++;
        map.forEach((key,value) -> System.out.println("key: "+key+", value: "+((Student)value).name));
    }
}
