package priv.wmc.study.priority.thread.group;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;
import priv.wmc.study.priority.thread.ThreadUtils;

/**
 * 新思路：在RegulationTwo的基础上，让消费者一来就先睡觉，这样之后达成一致，醒来就干活不用管对方是否把活干完了
 *
 * 注意：消费者的一来就睡不能放在{@code RegulationThree.consume}中，因为这是给主线程执行的...，线程要执行的代码必须放在Runnable.run中
 *
 * @author 王敏聪
 * @date 2020-03-18 14:53:27
 */
@Slf4j
public class RegulationThree implements ProduceAndConsumeRegulationInterface {

    private static final Lock LOCK = new ReentrantLock();
    private static final Condition PRODUCER_CONDITION = LOCK.newCondition();
    private static final Condition CONSUMER_CONDITION = LOCK.newCondition();

    @Override
    public Runnable produce() {
        return RegulationThree::producing;
    }

    @Override
    public Runnable consume() {
        return RegulationThree::consuming;
    }

    /**
     * 生产方法
     */
    public static void producing() {
        while(true) {
            LOCK.lock();
            try {
                // 生产
                log.info(ThreadUtils.getCurrentThreadInfo() + "进入房间，开始生产...");
                try {Thread.sleep(1000);} catch (InterruptedException e1) {e1.printStackTrace();}
                log.info(ThreadUtils.getCurrentThreadInfo() + "生产了: " + ++Demo.RESOURCE);

                // 生产队生产完毕 -> 叫醒消费队
                if (Demo.RESOURCE.equals(Demo.PRODUCER_AND_CONSUMER_SUM)) {
                    log.info(ThreadUtils.getCurrentThreadInfo() + "生产的是最后一件，生产队生产完毕，去消费室把消费队叫醒...");
                    CONSUMER_CONDITION.signalAll();
                }

                // 休息
                log.info(ThreadUtils.getCurrentThreadInfo() + "开始休息...");
                PRODUCER_CONDITION.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
                log.info(ThreadUtils.getCurrentThreadInfo() + "离开房间");
            }
        }
    }

    /**
     * 消费方法
     */
    public static void consuming() {
        // 这里的日志不需要打印的很详细了吧，要详细的话：实际就是消费者依赖就去房间睡 -> 被叫醒 -> 出房间 -> 回房间 -> 消费 ->...
        LOCK.lock();
        try {
            log.info(ThreadUtils.getCurrentThreadInfo() + "一来就睡");
            CONSUMER_CONDITION.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }

        while(true) {
            LOCK.lock();
            try {
                // 消费
                log.info(ThreadUtils.getCurrentThreadInfo() + "进入房间，开始消费...");
                try {Thread.sleep(1000);} catch (InterruptedException e1) {e1.printStackTrace();}
                log.info(ThreadUtils.getCurrentThreadInfo() + "消费了: " + Demo.RESOURCE--);

                // 是否消费完毕 -> 开始生产
                if (Demo.RESOURCE.equals(0)) {
                    log.info(ThreadUtils.getCurrentThreadInfo() + "消费的是最后一件，消费队消费完毕，去生产室叫醒生产队...");
                    PRODUCER_CONDITION.signalAll();
                }

                // 休息
                log.info(ThreadUtils.getCurrentThreadInfo() + "开始休息...");
                PRODUCER_CONDITION.await();
            } catch (InterruptedException e) {
                LOCK.unlock();
                log.info(ThreadUtils.getCurrentThreadInfo() + "被叫醒，离开房间");
            }

        }
    }

}
