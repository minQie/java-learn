package priv.wmc.study.senior.thread.demo;

import lombok.extern.slf4j.Slf4j;
import priv.wmc.study.senior.thread.ThreadUtils;

/**
 * 提问：能不能，不使用任何标识位，单纯的通过synchronized的嵌套来解决？
 * 回答：不是针对这个问题，首先要思考如何达成生产队和消费队的轮流，仅通过房间的门机制，
 *         那这个门要做到某个时刻仅允许特定队伍的人进入，并且达成某些特定条件的时候，允许进入的队伍标识还要切换一下，而门只有一个功能已经说了，所以凉凉
 *
 * 就像Demo中说的一样：synchronized的嵌套如何类比理解：不能理解为大房间里有小房间，因为这样会有你人在小房间，同时你人也在大房间的错误理解，实际在同步嵌套中：
 * 例如，A同步嵌套B同步，你在B的同步代码快中调用A.wait()，会抛出异常的，所以要向上面的理解那样，像上面那样，你说你不出房间B，却要睡在房间A，当然是不很合理的
 *
 * @author Wang Mincong
 * @date 2020-03-15 21:02
 */
@Slf4j
public class RegulationOne implements ProduceAndConsumeRegulationInterface {

    /**
     * 生产队是否都已经生产好了
     * 疑问：只要比较当前生产数量和人数，不就知道生产好了么，为啥要这个
     * 回答：当生产队生产好了，需要两个消费者消费，假设消费者1消费好了，轮到消费者2了，你说只看数量，消费者2肯定认为生产队还没有生产好
     */
    public static Boolean isProduceOk = false;

    @Override
    public Runnable produce() {
        return RegulationOne::producing;
    }

    @Override
    public Runnable consume() {
        return RegulationOne::consuming;
    }

    /**
     * 生产方法
     */
    public static void producing() {
        while(true) {
            synchronized (RegulationTest.PRODUCER_GROUP) {
                log.info(ThreadUtils.getCurrentThreadInfo() + "进入生产室，准备生产");

                // 消费队还没有生产好，别干忙活，先睡着，反正消费队消费好会来叫醒自己
                if (isProduceOk) {
                    try {
                        log.info(ThreadUtils.getCurrentThreadInfo() + "消费队还没有消费完，无法生产，开始睡觉...");
                        RegulationTest.PRODUCER_GROUP.wait();
                        log.info(ThreadUtils.getCurrentThreadInfo() + "被叫醒");
                    } catch (InterruptedException | IllegalMonitorStateException e) {
                        e.printStackTrace();
                    }
                }

                // 生产
                log.info(ThreadUtils.getCurrentThreadInfo() + "开始生产...");
                try {Thread.sleep(1000);} catch (InterruptedException e1) {e1.printStackTrace();}
                log.info(ThreadUtils.getCurrentThreadInfo() + "生产了: " + ++RegulationTest.RESOURCE);

                // 是否生产完
                if (RegulationTest.RESOURCE.equals(RegulationTest.PRODUCER_AND_CONSUMER_SUM)) {
                    isProduceOk = true;
                    // 生产队要确保把消费队叫醒，所以必须要进到消费室（所以此时要求，消费队一定都是睡着的，或者没有人在里面，这里保证前者）
                    synchronized(RegulationTest.CONSUMER_GROUP) {
                        log.info(ThreadUtils.getCurrentThreadInfo() + "生产的是最后一件，生产队生产完毕，去消费室把消费队叫醒...");
                        RegulationTest.CONSUMER_GROUP.notifyAll();
                    }
                }

                // 休息
                try {
                    log.info(ThreadUtils.getCurrentThreadInfo() + "生产完毕，开始睡觉...");
                    RegulationTest.PRODUCER_GROUP.wait();
                    log.info(ThreadUtils.getCurrentThreadInfo() + "被叫醒");
                } catch (InterruptedException | IllegalMonitorStateException e) {
                    e.printStackTrace();
                }
            }
            log.info(ThreadUtils.getCurrentThreadInfo() + "离开生产室");
        }
    }

    /**
     * 消费方法
     */
    public static void consuming() {
        while(true) {
            synchronized (RegulationTest.CONSUMER_GROUP) {
                log.info(ThreadUtils.getCurrentThreadInfo() + "进入消费室，准备消费");

                // 生产队还没有生产好，别干忙活，先睡着，反正生产队生产好会来叫醒自己
                if (!isProduceOk) {
                    try {
                        log.info(ThreadUtils.getCurrentThreadInfo() + "生产队还没有生产完，无法消费，开始睡觉...");
                        RegulationTest.CONSUMER_GROUP.wait();
                        log.info(ThreadUtils.getCurrentThreadInfo() + "被叫醒");
                    } catch (InterruptedException | IllegalMonitorStateException e) {
                        e.printStackTrace();
                    }
                }

                // 消费
                log.info(ThreadUtils.getCurrentThreadInfo() + "开始消费...");
                try {Thread.sleep(1000);} catch (InterruptedException e1) {e1.printStackTrace();}
                log.info(ThreadUtils.getCurrentThreadInfo() + "消费了: " + RegulationTest.RESOURCE--);

                // 是否消费完
                if (RegulationTest.RESOURCE.equals(0)) {
                    isProduceOk = false;
                    // 同理，去生产室叫醒生产队
                    synchronized(RegulationTest.PRODUCER_GROUP) {
                        log.info(ThreadUtils.getCurrentThreadInfo() + "消费的是最后一件，消费队消费完毕，去生产室叫醒生产队...");
                        RegulationTest.PRODUCER_GROUP.notifyAll();
                    }
                }

                // 休息
                try {
                    log.info(ThreadUtils.getCurrentThreadInfo() + "消费完毕，开始睡觉...");
                    RegulationTest.CONSUMER_GROUP.wait();
                    log.info(ThreadUtils.getCurrentThreadInfo() + "被叫醒");
                } catch (InterruptedException | IllegalMonitorStateException e) {
                    e.printStackTrace();
                }
            }
            log.info(ThreadUtils.getCurrentThreadInfo() + "离开消费室");
        }
    }

}
