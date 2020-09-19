package priv.wmc.study.basic;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-09-09 19:58:13
 */
public class ArraysTest {

    @Test
    public void deepToStringTest() {
        Person[] persons = {new Person(10, "小明")};

        String deepToString = Arrays.deepToString(persons);

        // [Lpriv.wmc.study.basic.ArraysTest$Person;@1ce92674
        System.out.println(persons);
        // [ArraysTest.Person(age=10, name=小明)]
        System.out.println(deepToString);
    }

    @ToString
    @AllArgsConstructor
    private static class Person {
        private int age;
        private String name;
    }

}
