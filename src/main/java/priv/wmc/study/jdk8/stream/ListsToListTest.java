package priv.wmc.study.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-07-19 10:34:28
 */
public class ListsToListTest {

    @Test
    public void test() {
        this.flatMapDemo();
    }

    /**
     * 将多个list合并成一个list
     */
    public void flatMapDemo() {
        List<List<String>> listList = new ArrayList<>(2);
        listList.add(Arrays.asList("11", "12"));
        listList.add(Arrays.asList("21", "22"));

        // 看下面参数，花里胡哨，flatMap整体意思就是：将一个List<Xxx>中所有Xxx中的List<Yyy>合并成一个List<Yyy>
        // Function<? super List<String>, ? extends Stream<? extends String>> mapper
        List<String> stringList = listList.stream().flatMap(List::stream).collect(Collectors.toList());
    }

}
