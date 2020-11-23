package stream;

import java.util.*;

/**
 * StreamAPI と ラムダ式の基本
 */
public class Sample {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Moriya", 80));
        studentList.add(new Student("Saito", 70));
        studentList.add(new Student("Yanamoto", 60));
        studentList.add(new Student("Yamada", 30));
        studentList.add(new Student("Ise", 100));

        studentList.stream()
                .filter(s -> s.getScore() >= 70)
                .forEach(System.out::println);

        System.out.println();

        Map<String, Integer> studentMap = new HashMap<>();
        studentMap.put("Moriya", 80);
        studentMap.put("Saito", 70);
        studentMap.put("Yanamoto", 60);
        studentMap.put("Yamada", 30);
        studentMap.put("Ise", 100);

        studentMap.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

    }

}
