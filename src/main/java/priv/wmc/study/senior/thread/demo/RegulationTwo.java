package priv.wmc.study.senior.thread.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;
import priv.wmc.study.senior.thread.ThreadUtils;

/**
 * RegulationOne的synchronized 替换成 lock 一套（注意，这样写是没有实现题干要求的两个房间的）
 *
 * 发现的优点：
 * 1、原本靠synchronized的“{”和“}”限定的房间范围，变为由LOCK的“lock”和“unlock”两个方法之间
 * 2、题目要求实现的效果，使用lock的话只需要一把锁，相当于只需要一个房间
 *
 * @author Wang Mincong
 * @date 2020-03-18 14:53:27
 */
@Slf4j
public class RegulationTwo implements ProduceAndConsumeRegulationInterface {

    private static final Lock LOCK = new ReentrantLock();
    private static final Condition PRODUCER_CONDITION = LOCK.newCondition();
    private static final Condition CONSUMER_CONDITION = LOCK.newCondition();

    public static Boolean isProduceOk = false;

    @Override
    public Runnable produce() {
        return RegulationTwo::producing;
    }

    @Override
    public Runnable consume() {
        return RegulationTwo::consuming;
    }

    /**
     * 生产方法
     */
    public static void producing() {
        while(true) {
            log.info(ThreadUtils.getCurrentThreadInfo() + "进入房间，准备生产");
            LOCK.lock();
            try {
                // 消费队还没有生产好，别干忙活，先睡着，反正消费队消费好会来叫醒自己
                if (isProduceOk) {
                    log.info(ThreadUtils.getCurrentThreadInfo() + "消费队还没有消费完，无法生产，开始睡觉...");
                    PRODUCER_CONDITION.await();
                    log.info(ThreadUtils.getCurrentThreadInfo() + "被叫醒");
                }

                // 生产
                log.info(ThreadUtils.getCurrentThreadInfo() + "开始生产...");
                try {Thread.sleep(1000);} catch (InterruptedException e1) {e1.printStackTrace();}
                log.info(ThreadUtils.getCurrentThreadInfo() + "生产了: " + ++Demo.RESOURCE);

                // 生产队生产完毕 -> 叫醒消费队
                if (Demo.RESOURCE.equals(Demo.PRODUCER_AND_CONSUMER_SUM)) {
                    isProduceOk = true;
                    log.info(ThreadUtils.getCurrentThreadInfo() + "生产的是最后一件，生产队生产完毕，去消费室把消费队叫醒...");
                    CONSUMER_CONDITION.signalAll();
                }

                // 休息
                log.info(ThreadUtils.getCurrentThreadInfo() + "开始休息...");
                PRODUCER_CONDITION.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.info(ThreadUtils.getCurrentThreadInfo() + "被叫醒，离开房间");
                LOCK.unlock();
            }
        }
    }

    /**
     * 消费方法
     */
    public static void consuming() {
        while(true) {
            LOCK.lock();
            log.info(ThreadUtils.getCurrentThreadInfo() + "进入房间");
            try {

                // 生产队还没有生产好，别干忙活，先睡着，反正生产队生产好会来叫醒自己
                if (!isProduceOk) {
                    log.info(ThreadUtils.getCurrentThreadInfo() + "生产队还没有生产完，无法消费，开始睡觉...");
                    CONSUMER_CONDITION.await();
                    log.info(ThreadUtils.getCurrentThreadInfo() + "被叫醒");
                }

                // 消费
                log.info(ThreadUtils.getCurrentThreadInfo() + "开始消费...");
                try {Thread.sleep(1000);} catch (InterruptedException e1) {e1.printStackTrace();}
                log.info(ThreadUtils.getCurrentThreadInfo() + "消费了: " + Demo.RESOURCE--);

                // 是否消费完毕 -> 开始生产
                if (Demo.RESOURCE.equals(0)) {
                    isProduceOk = false;
                    log.info(ThreadUtils.getCurrentThreadInfo() + "消费的是最后一件，消费队消费完毕，去生产室叫醒生产队...");
                    PRODUCER_CONDITION.signalAll();
                }

                // 休息
                log.info(ThreadUtils.getCurrentThreadInfo() + "开始休息...");
                PRODUCER_CONDITION.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.info(ThreadUtils.getCurrentThreadInfo() + "被叫醒，离开房间");
                LOCK.unlock();
            }

        }
    }

}
