package localDateTime;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * 日付操作
 */
public class Sample {
    public static void main(String[] args) {

        // 現在日時
        System.out.printf("日付:%s"+System.lineSeparator(), LocalDate.now());
        System.out.printf("時間:%s"+System.lineSeparator(), LocalTime.now());
        System.out.printf("日時:%s"+System.lineSeparator(), LocalDateTime.now());

        // 指定した日時
        LocalDate myBirthday = LocalDate.of(1981, Month.JUNE, 15);
        System.out.printf("生年月日: %s年%s月%s日"+System.lineSeparator(), myBirthday.getYear(), myBirthday.getMonthValue(), myBirthday.getDayOfMonth());
        // Formatterを利用すると簡単
        System.out.printf("生年月日: %s"+System.lineSeparator(), DateTimeFormatter.ofPattern("yyyy年M月dd日").format(myBirthday));

        // 日付の計算
        LocalDate tenYearsAfter = LocalDate.now().plusYears(10);
        System.out.printf("10年後は %s年です。"+System.lineSeparator(), tenYearsAfter.getYear());
    }

}
