package priv.wmc.study.basic.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 1、ArrayList的默认数组大小，见ArrayList.calculateCapacity(Object[] elementData, int minCapacity)
 * 2、ArrayList不能跨下标添加元素，见ArrayList.rangeCheckForAdd(int index)
 *
 * @author Wang Mincong
 * @date 2020-07-21 20:41:09
 */
@Slf4j
public class ArrayListIndexTest {

    @Test
    public void test() {
        /// 下面的方法返回的是Immutable object
        // List<String> list = Collections.emptyList();
        // List<String> list = Collections.singletonList("a");
        // 不要被Arrays.asList方法的源码迷惑，里边的ArrayList是内部类的ArrayList
        // List<String> list = Arrays.asList("a");

        List<String> list = new ArrayList<>();
        list.add("a");

        list.add(1,"b");
        // 上面的语句注释掉就报下标越界异常，struts2的数组属性驱动就可以按照指定的位置提交参数，不会报错，空位补null
        list.add(2,"c");

        System.out.println(list);
    }

}
