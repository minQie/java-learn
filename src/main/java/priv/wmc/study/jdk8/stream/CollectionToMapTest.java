package priv.wmc.study.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import priv.wmc.study.jdk8.stream.pojo.Person;

/**
 * 将集合转成Map
 *
 * @author Wang Mincong
 * @date 2020-07-19 10:24:54
 */
@Slf4j
public class CollectionToMapTest {

    @Test
    public void test() {
        List<Person> personList = Arrays.asList(
            new Person(10, "小明"),
            new Person(11, "中明"),
            new Person(12, "大明")
        );
        Map<String, Person> stringPersonMap = this.toMap(personList);

        log.info(stringPersonMap.toString());
    }

    public Map<String, Person> toMap(List<Person> personList) {
        Function<Person, Person> valueProvider = person -> person;
//        Function<Person, Person> valueProvider = Function.identity();

        return personList.stream()
            // Map的键、Map的值、当键重复时的保留策略
            .collect(Collectors.toMap(Person::getName, valueProvider, (person1, person2) -> person1));
    }

}

