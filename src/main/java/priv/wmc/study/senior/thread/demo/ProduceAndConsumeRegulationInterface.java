package priv.wmc.study.senior.thread.demo;

/** 
 * 生产消费测试的约定接口
 * 
 * @author Wang Mincong
 * @date 2020-03-15 21:05
 */
public interface ProduceAndConsumeRegulationInterface {
    
    /**
     * 决定生产方式
     * 
     * @return 生产方式
     */
    Runnable produce();
    
    /**
     * 决定消费方式
     * 
     * @return 消费方式
     */
    Runnable consume();

}
