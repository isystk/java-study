package streamMap;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String groupName;

    private List<Student> students = new ArrayList<>();

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void add(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
