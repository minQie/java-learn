package priv.wmc.study.senior.thread;

/** 
 * @author Wang Mincong
 * @date 2020-03-15 21:17
 */
public final class ThreadUtils {

    private ThreadUtils() {}

    /**
     * 打印当前线程信息的方法
     */
    public static String getCurrentThreadInfo() {
        return "["
//                + "ThreadGroupName: " + Thread.currentThread().getThreadGroup().getName() + ", "
//                + "ThreadName: "
                + Thread.currentThread().getName() + "] - ";
    }

}
