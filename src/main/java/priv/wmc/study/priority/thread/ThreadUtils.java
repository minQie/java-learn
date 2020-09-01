package priv.wmc.study.priority.thread;

/** 
 * @author 王敏聪
 * @date 2020-03-15 21:17
 */
public class ThreadUtils {

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
