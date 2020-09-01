package priv.wmc.study.priority.thread.group;

import lombok.extern.slf4j.Slf4j;

/**
 * 场景、规则描述：
 * 1、有两个生产者他们组成生产队，有两个消费者他们组成消费队，他们分别需要生产和消费“RESOURCE”
 * 2、有一个生产室“PRODUCER_GROUP”，但是只有一套生产工具，有一个消费室“CONSUMER_GROUP”，但是也只有一套消费工具
 * 3、门都是自动的，只要有醒着的人在里面，门就会关闭，但是人想要出去，是可以打开门出去的
 * 4、每人生产或消费好一个就会累的睡着，并且有人在外面敲门，里面的人就会醒
 * 5、生产队的生产者都生产好，才会去敲门提醒两个消费者可以消费了；同理，消费者消费好了也会去敲门提醒生产者，这样往复循环
 *
 * 思考的提示点：
 * 1、往复循环 -> 代码有死循环
 * 2、控制同一时间职能有一个人进入房间的操作当然只能由同步的相关代码（上面说的门）来保证，并且同步也只能做这个，起到这样的效果
 * 3、synchronized的嵌套如何类比理解：不能理解为大房间里有小房间，因为这样会有你人在小房间，同时你人也在大房间的错误理解，实际在同步嵌套中：
 * 例如，A同步嵌套B同步，你在B的同步代码快中调用A.wait()，会抛出异常的，所以要向上面的理解那样，像上面那样，你说你不出房间B，却要睡在房间A，当然是不很合理的
 *
 * 疑问点：你会发现，把RegulationTwo在finally中释放锁的操作注释掉，RegualationTwo的运行效果也是正常的
 *
 * @author 王敏聪
 * @date 2020-03-14 13:58
 */
@Slf4j
public class Demo {

    public static Integer RESOURCE = new Integer(0);

    public static final Integer PRODUCER_AND_CONSUMER_SUM = 2;

    public static final ThreadGroup PRODUCER_GROUP = new ThreadGroup("生产队");
    public static final ThreadGroup CONSUMER_GROUP = new ThreadGroup("消费队");

    public static void start(ProduceAndConsumeRegulationInterface regulation) {
        Thread producer1 = new Thread(PRODUCER_GROUP, regulation.produce(), "生产者1");
        Thread producer2 = new Thread(PRODUCER_GROUP, regulation.produce(), "生产者2");

        Thread consumer1 = new Thread(CONSUMER_GROUP, regulation.consume(), "消费者1");
        Thread consumer2 = new Thread(CONSUMER_GROUP, regulation.consume(), "消费者2");

        log.info("生产者1报道");
        log.info("生产者2报道");
        log.info("消费者1报道");
        log.info("消费者2报道");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }

    public static void consumerSleepFirstStart(ProduceAndConsumeRegulationInterface regulation) {
        Thread producer1 = new Thread(PRODUCER_GROUP, regulation.produce(), "生产者1");
        Thread producer2 = new Thread(PRODUCER_GROUP, regulation.produce(), "生产者2");

        Thread consumer1 = new Thread(CONSUMER_GROUP, regulation.consume(), "消费者1");
        Thread consumer2 = new Thread(CONSUMER_GROUP, regulation.consume(), "消费者2");

        log.info("消费者1报道");
        log.info("消费者2报道");
        consumer1.start();
        consumer2.start();

        // 保证消费队先睡着
        try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}

        log.info("生产者1报道");
        log.info("生产者2报道");
        producer2.start();
        producer1.start();
    }

    public static void main(String[] args) {
//        start(new RegulationOne());
        start(new RegulationTwo());
//        consumerSleepFirstStart(new RegulationThree());
    }

}
