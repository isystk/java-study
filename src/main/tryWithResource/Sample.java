package tryWithResource;

import stream.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Try with Resource
 */
public class Sample {
    public static void main(String[] args) {

        try (BufferedReader br = Files.newBufferedReader(Paths.get("src/tryWithResource/sample.csv"))) {

            List<String> list = br.lines().collect(Collectors.toList());
            list.stream()
                    .map(line -> {
                        String name = line.split(",")[0];
                        int score = Integer.valueOf(line.split(",")[1]);
                        return score;
                    })
                    .forEach(System.out::println);

        } catch (IOException |
                NumberFormatException e) {
            e.printStackTrace();
        }

    }

}
