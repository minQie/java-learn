package priv.wmc.study.jdk7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * 参考：https://www.oschina.net/news/20119/new-features-of-java-7
 *
 * <p>1、switch 语句可以用字符串</p>
 * <p>2、泛型简化（即泛型推断） - 菱形表达式 - Diamond Operator</p>
 * <p>3、异常的多个catch合并</p>
 * <p>4、文件更改通知</p>
 * <p>5、Fork and Join（Fork/Join框架）</p>
 *
 * @author Wang Mincong
 * @date 2020-07-25 15:24:22
 */
public class Concept {

    @Test
    public void test() {
        // Raw use of parameterized class 'List'
        List list = new ArrayList<Number>();
        // Unchecked assignment: 'java.util.List' to 'java.util.List<java.lang.String>'
        List<String> stringList = list;
        // Unchecked call to 'add(int, E)' as a member of raw type 'java.util.List'
        list.add(0, 1);
        Concept.addToList(stringList, "1");

    }

    public static <T> void addToList(List<T> listArg, T... elements) {
        listArg.addAll(Arrays.asList(elements));
    }

}
