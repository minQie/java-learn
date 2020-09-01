package priv.wmc.study.basic.execute.behavior;

import org.junit.Test;

/**
 * 本以为父类构造方法中调用的方法，父类如果有，当然调用父类的，实际是如果子类重载了，那就是调用子类的
 *
 * @author Wang Mincong
 * @date 2020-06-14 16:49:15
 */
public class ExecuteTest {

    @Test
    public void demo() {
        Child child = new Child();
        child.fun();
    }

}
