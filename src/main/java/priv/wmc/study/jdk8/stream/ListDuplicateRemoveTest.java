package priv.wmc.study.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 列表去重
 *
 * @author Wang Mincong
 * @date 2020-09-22 16:15:30
 */
@Slf4j
public class ListDuplicateRemoveTest {

    @Test
    public void test() {
        List<String> strList = Arrays.asList("1", "1", "2", "3");

        // 方法一、通过 stream
        List<String> nonDuplicateList = strList.stream().distinct().collect(Collectors.toList());

        // 方法二、直接转 Set
//        Set<String> set = strList.stream().collect(Collectors.toSet());
        // 上面不推荐，因为 HashSet 支持参数类型为 Collection 的构造，ArrayList同理
        Set<String> set = new HashSet<>(strList);

        log.info(nonDuplicateList.toString());
        log.info(set.toString());
    }

}
