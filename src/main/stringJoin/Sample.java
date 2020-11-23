package stringJoin;

import stream.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * String join
 */
public class Sample {
    public static void main(String[] args) {

        // StringBuilderはもう使わない
        String builder = String.join(
                System.lineSeparator(),
                "111",
                    "222",
                    "333",
                    "444");
        System.out.println(builder);
    }

}
