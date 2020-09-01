package priv.wmc.study.basic.enums;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2020-07-21 20:59:23
 */
@Slf4j
public class Demo {

    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
//        demo4();
//        log.info(Animal.getById("2") == Animal.CAT);

        log.info(Animal.CAT.name());
    }

    public static void demo1() {
        String id = "1";

        Animal animal = Animal.getById(id);

        switch (animal) {
            case CAT:
                log.info("猫");
                break;
            case DOG:
                log.info("狗");
                break;
            default:
                log.info("非猫非狗");
                break;
        }
    }

    /**
     * 枚举的toString方法
     */
    public static void demo2() {
        log.info(Animal.CAT.toString());// CAT
        log.info(Animal.CAT.toString());// CAT
    }

    /**
     * 枚举的compareTo方法
     */
    public static void demo3() {
        log.info(String.valueOf(Animal.CAT.compareTo(Animal.CAT)));
        log.info(String.valueOf(Animal.CAT.compareTo(Animal.DOG)));
    }

    /**
     * 枚举的ordinal方法
     */
    public static void demo4() {
        log.info(String.valueOf(Animal.CAT.ordinal())); // 0
        log.info(String.valueOf(Animal.DOG.ordinal())); // 1
    }
}
