package priv.wmc.study.basic.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import priv.wmc.study.util.LogUtils;

/**
 * 移除集合中的元素应该通过迭代器去实现，但是j.u.c包下的集合是可以直接通过for循环移除元素的
 *
 * jdk1.5以前的集合设计是fail-fast思想
 * jdk1.5以后的j.u.c包下的集合设计遵从fast-safe思想
 *
 * PS：集合类 remove 方法的源码实现是操作内部的数组
 *
 * @author Wang Mincong
 * @date 2020-07-30 21:33:33
 */
@Slf4j
public class ForeachRemoveTest {

    @Test
    public void test() {
        // juc 包下的集合支持不使用迭代器的 foreachRemove
        foreachNotIteratorRemoveListExample();
        // 下标处理好，也是可以在 for 中进行 remove的
        forLoopRemoveListExample();
        // 当然，标准的 foreachRemove，可以使用1.8 Collection 接口新增默认接口方法 removeIf
        new ArrayList<>(Arrays.asList(1, 2, 3)).removeIf(item -> item != 1);
    }

    /**
     * 通过 foreach 语法糖遍历移除集合中所有的元素
     */
    private void foreachRemove(Collection<?> collection) {
        // 下面的不是编译错误，而是idea的友情提示
        for (Object obj : collection) {
            collection.remove(obj);
        }
    }

    public void foreachNotIteratorRemoveListExample() {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> vector = new Vector<>(arrayList);
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(arrayList);

        // ConcurrentModificationException
        this.foreachRemove(arrayList);

        // ConcurrentModificationException（线程安全的结合也是会出现该异常的）
        this.foreachRemove(vector);

        // √
        this.foreachRemove(copyOnWriteArrayList);
        LogUtils.log(copyOnWriteArrayList);
    }

    /**
     * 通过 for 循环，以遍历下标的方式删除list中所有的元素
     * 下标只要把握的好，for 循环中进行 remove 操作，就不会导致 CurrentModificationException
     *
     * PS：实际上foreach的底层就是迭代器，而问题的核心就是 ArrayList.remove 和 Iterator.remove 的区别
     * （Iterator的移除会修正校验标识，而ArrayList就不会）
     */
    private void forLoopRemoveListExample() {
        List<?> list = new ArrayList<>(Arrays.asList(1, 2 ,3));

        int size = list.size();

        // 移除所有
//        for (int i = 0; i < size; i++) {
//            list.remove(0);
//        }

        // 正向遍历：移除集合中间的元素
//        for (int i = 0; i < size; i++) {
//            LogUtils.log(list.get(i));
//            if (i == size/2) {
//                list.remove(i--);
//            }
//        }

        // 逆向遍历：移除集合中间的元素
        for (int i = size - 1; i >= 0; i--) {
            LogUtils.log(list.get(i));
            if (i == size/2) {
                list.remove(i);
            }
        }
    }

}
