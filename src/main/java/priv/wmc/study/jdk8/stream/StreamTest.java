package priv.wmc.study.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Function<T, T> Consumer<T>
 *
 * stream of elements  --> limit --> filter --> sorted --> map、peak --> distinct --> collect/count
 *
 * 1、生成流：
 *    stream() − 为集合创建串行流
 *    parallelStream() − 为集合创建并行流
 *
 * 2、流Stream，可以让你以一种声明的方式处理数据
 *    Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象
 *    Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码
 *    这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等
 *    元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果
 *
 * 3、Stream（流）是一个来自数据源的元素队列并支持聚合操作
 *    元素是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算
 *    数据源 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等
 *    聚合操作 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等
 *
 * 4、和以前的Collection操作不同， Stream操作还有两个基础的特征：
 *    Pipelining: 中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道， 如同流式风格（fluent style）
 *    这样做可以对操作进行优化， 比如延迟执行(laziness)和短路(short-circuiting)
 *    内部迭代： 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代
 *    Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现
 *
 *  5、操作特性
 *    不存储数据
 *    不改变源数据
 *    不可重复使用
 *
 * @author Wang Mincong
 * @date 2019-08-24 16:27
 */
public class StreamTest {

    @Test
    public void test() {
        // 中间节点、拦截点（只要不执行终值节点，中间节点和拦截点是不执行的）
        // 中间节点、终值节点的判断条件：方法返回值类型是否是Stream
//        Arrays.stream(new Long[] {1L, 2L}).peek(System.out::print); 不输出东西
//        Arrays.stream(new Long[]{1L, 2L}).collect(Collectors.joining(", ")); 凉凉
        String collect = String.join(", ", "1", "2");
        String collect1 = Arrays.stream(new String[]{"1", "2"}).collect(Collectors.joining(", "));
        String collect2 = Stream.of(new String[]{"1", "2"}).collect(Collectors.joining(", "));
        String collect3 = Stream.of("1", "2").collect(Collectors.joining(", "));

        // foreach和peek：peek是中间节点、foreach是终值节点
//        List<User> list =  Arrays.asList(new User("小明"), new User("大明"));
//        list.forEach(user -> user.setUsername("明"));
//        log.info(list);

        // 使用stream的同时还想使用循环下标
//        List<String> list = Arrays.asList("a", "b");
//        Stream.iterate(0, i -> i + 1).limit(list.size()).forEach(index -> {
//            log.info(index + ": " + list.get(index));
//        });
    }

}
