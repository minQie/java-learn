package priv.wmc.study.basic.inner;

/**
 * @author Wang Mincong
 * @date 2020-07-19 10:05:34
 */
public class In {

    public static void test(){
        int x = 1;
        // 内部类访问的外部局部变量或者成员必须是静态的
//        x = 2;
        new Out() {
            public int method() {
                return x;
            }
        }.method();
    }
}

/**
 * @author Wang Mincong
 * @date 2020-07-19 10:05:51
 */
class Out {}
