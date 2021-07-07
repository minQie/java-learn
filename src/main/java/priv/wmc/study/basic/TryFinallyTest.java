package priv.wmc.study.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 点：finally一定会执行么
 *
 * @author Wang Mincong
 * @date 2020-08-19 15:50:08
 */
@Slf4j
public class TryFinallyTest {

    @Test
    public void test() {
        Boolean flag = false;
        try {
            // 扯皮：当 flag = null，finally就能执行（虚拟机 Unboxing，调用 Boolean.booleanValue 的方法时，报错）
            // 下面两个分支的语句都能保证 finally不会被执行，即除了永远不会被执行，或者 JVM 退出，否则 finally 都会执行
            if (flag) {
                while (true) {}
            } else {
                System.exit(0);
            }
        } finally {
            System.out.println("finally...");
        }
    }

    @Test
    public void TestReturn() {
        log.info(String.valueOf(Test0()));
        log.info(String.valueOf(Test1()));
    }

    public int Test0() {
        try {
            return 1;
        } finally {
            // 最终返回 2
            return 2;
        }
    }

    public int Test1() {
        int i = 1;

        try {
            // 最终返回 1，finally 加的值不起作用
            return i;
        } finally {
            i++;
        }
    }
}
