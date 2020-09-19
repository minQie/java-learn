package priv.wmc.study.basic.string;

import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-09-14 21:49:37
 */
public class ReplaceTest {

    @Test
    public void test() {
        String source = "\\\\";

        // 输出：--
        System.out.println(source.replace("\\", "-"));
        // 输出：--
        System.out.println(source.replaceAll("\\\\", "-"));

        // 如何理解？
        // 1、将所有转移符号前面的 \ 去掉，因为这是为了匹配 java 编译器做的处理
        // 2、接下来再看，replace方法的参数就是实际的字符，而replaceAll方法的参数是正则表达式，而正则表达式中想表示一个 \ 转译字符，同样需要一个转译字符来修饰，最终也就是看到的四个 \
    }

}
