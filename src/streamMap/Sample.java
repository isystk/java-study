package streamMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamAPIの中間操作
 */
public class Sample {
    public static void main(String[] args) {

        List<Group> groups = new ArrayList<>();

        Group group1 = new Group();
        group1.add(new Student("Ise", 100));
        group1.add(new Student("Moriya", 80));
        group1.add(new Student("Saito", 70));
        groups.add(group1);

        Group group2 = new Group();
        group2.add(new Student("Yamada", 30));
        group2.add(new Student("Yamamoto", 60));
        group2.add(new Student("Noguchi", 55));
        groups.add(group2);

        groups.stream()
                .map(g -> g.getStudents())
                .forEach(System.out::println);

        System.out.println();

        // flatMapを利用すると複数のStreamを結合して1つのStreamとして扱える。
        groups.stream()
                .flatMap(g -> g.getStudents().stream())
                .sorted((s1, s2) -> s2.getScore() - s1.getScore()) // スコアの高い順にソート
                .filter(s -> s.getScore() > 50) // スコアが50より大きい人のみ
                .limit(3) // 上位3件を表示
                .forEach(System.out::println);

        System.out.println();

        // NameをCSVとして出力
        String csv = groups.stream()
                .flatMap(g -> g.getStudents().stream())
                .map(s -> s.getName())
                .collect(Collectors.joining(","));
        System.out.println(csv);

        // スコアが50以上の名称を大文字で表示
        List<Student> studentList = groups.stream()
                .flatMap(g -> g.getStudents().stream())
                .collect(Collectors.toList());
        studentList.removeIf(s -> s.getScore() < 50); // スコアが50未満を削除
        List<String> stringNameList = studentList.stream()
                .map(s -> s.getName())
                .collect(Collectors.toList());
        stringNameList.replaceAll(s -> s.toUpperCase()); // 名前を大文字に変換
        System.out.println(stringNameList);

    }

}
