package priv.wmc.study.interview;

import org.junit.Test;

/**
 * 点：finally一定会执行么
 *
 * @author Wang Mincong
 * @date 2020-08-19 15:50:08
 */
public class TryFinallyTest {

    @Test
    public void test() {
        Boolean flag = false;
        try {
            // 扯皮：当flag = null，finally就能执行（虚拟机Unboxing，调用Boolean.booleanValue的方法时，报错）
            // 下面两个分支的语句都能保证finally不会被执行，即除了永远不会被执行，或者 JVM 退出，否则finally都会执行
            if (flag) {
                while (true) {}
            } else {
                System.exit(0);
            }
        } finally {
            System.out.println("finally...");
        }
    }

}
