package beanCopy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<Student> students = new ArrayList<>();

    private String className;

    private LocalDateTime registTime;

    public LocalDateTime getRegistTime() {
        return registTime;
    }

    public void setRegistTime(LocalDateTime registTime) {
        this.registTime = registTime;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Group{" +
                "students=" + students +
                ", className='" + className + '\'' +
                ", registTime='" + DateTimeFormatter.ofPattern("yyyy/MM/dd").format(registTime) + '\'' +
                '}';
    }

}
