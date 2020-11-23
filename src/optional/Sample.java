package optional;

import java.util.*;

/**
 * Optional の利用
 */
public class Sample {
    public static void main(String[] args) {
        OptionalStack<String> optionalStack = new OptionalStack<>();
        Optional<String> optional = optionalStack.pop();

        // この時点ではoptionalStackが空なのでoptionalはEmptyとなっている。
        String optionalElement = optional.orElse("empty");
        System.out.println(optionalElement);

        optionalStack.push("Java");
        optionalStack.push("Kotlin");
        optionalStack.push("Scala");

        optional = optionalStack.pop();
        // optionalが空じゃない場合にIF文の中が処理される
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        optional = optionalStack.pop();

        // ifPresent を利用するとIF文を簡略化することもできる
        optional.ifPresent(System.out::println);
    }

}
