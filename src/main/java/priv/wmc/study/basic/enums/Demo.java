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

        log.info(AnimalEnum.CAT.name());
    }

    public static void demo1() {
        String id = "1";

        AnimalEnum animal = AnimalEnum.getById(id);

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
        log.info(AnimalEnum.CAT.toString());// CAT
        log.info(AnimalEnum.CAT.toString());// CAT
    }

    /**
     * 枚举的compareTo方法
     */
    public static void demo3() {
        log.info(String.valueOf(AnimalEnum.CAT.compareTo(AnimalEnum.CAT)));
        log.info(String.valueOf(AnimalEnum.CAT.compareTo(AnimalEnum.DOG)));
    }

    /**
     * 枚举的ordinal方法
     */
    public static void demo4() {
        log.info(String.valueOf(AnimalEnum.CAT.ordinal())); // 0
        log.info(String.valueOf(AnimalEnum.DOG.ordinal())); // 1
    }
}
