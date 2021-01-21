package streamMap;

import java.util.ArrayList;
import java.util.Arrays;
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

        Group group1 = new Group();
        group1.setGroupName("グループ１");
        group1.add(new Student("Ise", 100));
        group1.add(new Student("Moriya", 80));
        group1.add(new Student("Saito", 70));

        Group group2 = new Group();
        group2.setGroupName("グループ２");
        group2.add(new Student("Yamada", 30));
        group2.add(new Student("Yamamoto", 60));
        group2.add(new Student("Noguchi", 55));

        // ２つのグループを統合
        List<Student> top3List = Arrays.asList(group1, group2)
            .stream()
            .flatMap(g -> g.getStudents().stream())
            .sorted((s1, s2) -> s2.getScore() - s1.getScore()) // スコアの高い順にソート
            .filter(s -> s.getScore() > 50) // スコアが50より大きい人のみ
            .limit(3) // 上位3件を表示
            .collect(Collectors.toList());
        top3List.stream().forEach(System.out::println);

        System.out.println();

        // DTOのリストからnameだけのリストを生成する
        List<String> top3NameList = top3List.stream()
            .map((s) -> s.getName())
            .collect(Collectors.toList());
        top3NameList.stream().forEach(System.out::println);

        System.out.println();

        // NameをCSVとして出力
        String csv = top3NameList.stream()
                .collect(Collectors.joining(","));
        System.out.println(csv);

        System.out.println();

        // DTOのリストからMapを生成する
        Map<String, Student> top3NameMap = top3List.stream()
            .collect(Collectors.toMap(
                s -> s.getName(),
                s -> s));
        top3NameMap.entrySet().stream()
            .forEach(e -> System.out.println(e.getKey() + "→" + e.getValue()));

        System.out.println();

        // Nameのリストから配列を生成する
        String[] top3Names = top3NameList.stream()
            .toArray(String[]:: new);
        Arrays.asList(top3Names).stream().forEach(System.out::println);
    }

}
