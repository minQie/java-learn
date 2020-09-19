package priv.wmc.study.jdk8.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import priv.wmc.study.jdk8.stream.pojo.Person;

/**
 * compareTo 方法返回的值：
 * <0 第一个参数应该排在第二参数后面
 * =0 第一个参数应该排在第二参数后面
 * ?0 第一个参数应该排在第二个参数前面
 *
 * @author Wang Mincong
 * @date 2020-09-18 00:19:06
 */
public class SortTest {

    /**
     * 一定要注意要参与排序比较字段的空值问题，否则等着收获 NPE
     */
    @Test
    public void test() {
        List<Person> personList = Arrays.asList(
            new Person(null, "空"),
            new Person(10, "小明"),
            new Person(11, "中明"),
            new Person(12, "大明")
        );

        Comparator<Person> personComparator = Comparator
            .comparing(Person::getAge, Comparator.nullsFirst(Comparator.naturalOrder()))
            .thenComparing(Person::getName, Comparator.nullsLast(Comparator.naturalOrder()));

        // 拓展
//        Collections.sort(personList, personComparator);
//        personList.sort(personComparator);

        // 样例一
        List<Person> personSortedList = personList.stream()
            .sorted(personComparator)
            .collect(Collectors.toList());

        // 样例二 .sort.sort
        List<Person> personSortedList2 = personList.stream()
            .sorted(Comparator.comparing(Person::getAge, Comparator.nullsFirst(Comparator.naturalOrder())))
            .sorted(Comparator.comparing(Person::getName, Comparator.nullsLast(Comparator.naturalOrder())))
            .collect(Collectors.toList());

        // 样例三 实现 Comparator
        List<Person> personSortedList3 = personList.stream()
            .sorted((person1, person2) -> {
                if (person1.getAge() == null) {
                    return -1;
                }
                if (person2.getAge() == null) {
                    return 1;
                }
                int ageCompareResult = person1.getAge().compareTo(person2.getAge());
                if (ageCompareResult == 0) {
                    if (person1.getName() == null) {
                        return -1;
                    }
                    if (person2.getName() == null) {
                        return 1;
                    }
                    return person1.getName().compareTo(person2.getName());
                }
                return ageCompareResult;
            })
            .collect(Collectors.toList());

        System.out.println(personSortedList);
        System.out.println(personSortedList2);
        System.out.println(personSortedList3);
    }

}
