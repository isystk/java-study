package stream;

import java.util.*;

/**
 * StreamAPI と ラムダ式の基本
 */
public class Sample {
    public static void main(String[] args) {

        new ArrayList<Student>() {
            {
                add(new Student("Moriya", 80));
                add(new Student("Saito", 70));
                add(null);
                add(new Student("Yanamoto", 60));
                add(new Student("Yamada", 30));
                add(new Student("Ise", 100));
            }}
            .stream()
                // nullを除外
                .filter(s -> Objects.nonNull(s))
                // スコアが７０以上に絞る
                .filter(s -> s.getScore() >= 70)
                .forEach(System.out::println);

        System.out.println();

        new HashMap<>() {
            {
                put("Moriya", 80);
                put("Saito", 70);
                put("Yanamoto", 60);
                put("Yamada", 30);
                put("Ise", 100);
            }
        }.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

    }

}
