import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class Student {
    String name;
    int age;
    String soptDept;
    List<String> Friends;
    Map<String, String> proLangs;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSoptDept(String soptDept) {
        this.soptDept = soptDept;
    }

    public void setFriends(List<String> friends) {
        Friends = friends;
    }

    public void setProLangs(Map<String, String> proLangs) {
        this.proLangs = proLangs;
    }

    public String introMyself(){
        String content="이름: "+name+"\n 나이:"+age+"\n sopt 소속: "+soptDept+"\n 친구: "+Friends.toString()+"\n 언어:"+proLangs.toString();
        return content;
    }
}
