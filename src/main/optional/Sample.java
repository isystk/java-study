package optional;

import java.util.*;

/**
 * Optional の利用
 */
public class Sample {
    public static void main(String[] args) {
        String data = null;
        Optional<String> optional = Optional.ofNullable(data);

        // この時点ではdataが空なのでoptionalはEmptyとなっている。
        String optionalElement = optional.orElse("empty");
        System.out.println(optionalElement);

        data = "hoge";
        optional = Optional.ofNullable(data);

        // optionalが空じゃない場合にIF文の中が処理される
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        // ifPresent を利用するとIF文を簡略化することもできる
        optional.ifPresent(System.out::println);

    }

}
