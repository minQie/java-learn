package priv.wmc.study.basic.inner;

/**
 * @author Wang Mincong
 * @date 2020-07-19 10:05:34
 */
class FinalAccess {

    private FinalAccess() {}

    public static void test() {
        int x = 1;
        // 内部类访问的外部局部变量或者成员必须是常量（下面放开=编译时异常）
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
interface Out {}
