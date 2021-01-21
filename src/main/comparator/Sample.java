package comparator;

import anonymousClass.TaskHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Comparator を利用したソート処理
 */
public class Sample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
            new Student("Saito", 70),
            new Student("Yamada", 30),
            new Student("Ise", 100));

        System.out.println(studentList);

        // スコアの昇順でソート処理
        Collections.sort(studentList,
                (student1, student2) ->
                        Integer.compare(student1.getScore(), student2.getScore())
        );

        System.out.println(studentList);

    }

}
