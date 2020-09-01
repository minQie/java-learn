package priv.wmc.study.jdk8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Stream.summaryStatistics、Stream.group
 *
 * @author Wang Mincong
 * @date 2020-07-19 10:36:58
 */
@Slf4j
public class SummaryTest {

    @Test
    public void test() {
//        this.summaryDemo();
        this.groupingByDemo();
    }

    /**
     * 统计不同颜色苹果的平均质量
     */
    public void groupingByDemo() {
        List<Apple> appleList = Arrays.asList(
            new Apple("red", 60),
            new Apple("red", 80),
            new Apple("blue", 40),
            new Apple("blue", 50)
        );
        Map<String, Double> summaryMap = appleList.stream()
            .collect(Collectors.groupingBy(Apple::getColor, Collectors.averagingInt(Apple::getWeight)));

        log.info(summaryMap.toString());
    }

    /**
     * 数据统计，它们主要用于int、double、long等基本类型上
     */
    public void summaryDemo() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();

        log.info("列表中最大的数 : " + stats.getMax());
        log.info("列表中最小的数 : " + stats.getMin());
        log.info("所有数之和 : " + stats.getSum());
        log.info("平均数 : " + stats.getAverage());
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Apple {
        /** 颜色 */
        private String color;
        /** 质量 */
        private Integer weight;
    }

}
