package beanCopy;


import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Optional の利用
 */
public class Sample {

    public static void main(String[] args)
        throws InvocationTargetException, IllegalAccessException {

        Group group1 = new Group();
        group1.setClassName("Aクラス");
        group1.setRegistTime(LocalDateTime.now());
        group1.setStudents(List.of(new Student("Ise", 100),
                new Student("Moriya", 80),
                new Student("Saito", 70)));

        // Group1の値をGroup2にディープコピー
        Group group2 = new Group();
        BeanUtils.copyProperties(group2, group1);
        System.out.println(group2);

    }

}
