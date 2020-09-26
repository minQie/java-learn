package priv.wmc.study.senior.proxy.javassist.prio;

/**
 * @author Wang Mincong
 * @date 2020-07-18 20:04:09
 */
public interface InvocationHandler {

    /**
     * 核心待实现方法
     *
     * @param methodName 方法名
     * @param args 参数
     * @return 返回值
     */
    Object invoke(String methodName, Object[] args);

}
