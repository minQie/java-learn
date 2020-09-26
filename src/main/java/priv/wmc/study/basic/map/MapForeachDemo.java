package priv.wmc.study.basic.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2019-10-10 13:47
 */
@Slf4j
public class MapForeachDemo {

    @Test
    public void demo() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");

        this.forPutOrRemoveTest(map);

        log.info(map.toString());
    }

    /**
     * map.foreach
     * @param map
     */
    public void foreachTest(Map<String, String> map) {
        map.forEach((key, value) -> log.info("key:" + key + ", value: " + value));
    }

    /**
     * map.remove(Object key, Object value)
     * @param map
     */
    public void removeTest(Map<String, String> map) {
        map.remove("1", "1");
        map.remove("2", null);
    }

    /**
     * 增强的for循环添加或删除元素，同操作集合一样：java.util.ConcurrentModificationException（删除完立马break的除外）
     *
     * 结论：jdk不支持在遍历中对map进行增删（如果支持增的话，那新增的元素要不要继续遍历，模棱两可）
     *
     * @param map
     */
    public void forPutOrRemoveTest(Map<String, String> map) {
        Iterator<Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            log.info(it.next().toString());
            it.remove();
        }
    }

    /**
     * map.compute
     * @param map
     */
    public void computeTest(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            map.compute(entry.getKey(), (key, value) -> key.equals("1")? "是1": "不是1");
        }
    }

    /**
     * map.computeIfAbsent(key, mappingFunction)
     * @param map
     */
    public void computeIfAbsentTest(Map<String, String> map) {
        /**
         * 根据key取得的值为空
         *         将“key”作为参数传给Function
         *         “function的返回值”不为空
         *                 将“key”和“function的返回值”替换原键值对
         *                 返回“function的返回值”
         * 返回根据key取得的值
         */
//        map.computeIfAbsent(key, function);
    }

    /**
     * map.computeIfPresent(key, remappingFunction)
     * @param map
     */
    public void computeIfPresentTest(Map<String, String> map) {
        /*
         * 根据key取得的值不为空
         *         将“key”和“根据key取得的值”作为参数传给BiFunction
         *         将“key”和“biFunction的返回值”替换原键值对
         *         返回“biFunction的返回值”
         * 根据key取得的值为空
         *         移除该键值对
         *     	返回null
         */
//		map.computeIfPresent(key, biFunction);
    }

}
