package priv.wmc.study.priority.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 */
@Slf4j
public class Target implements EatInterface, DrinkInterface {

    @Override
    public void drinkTea() {
        log.info("喝茶");
    }

    @Override
    public void drinkJuice() {
        log.info("喝果汁");
    }

    @Override
    public void eatRice() {
        log.info("恰饭");
    }

    @Override
    public void eatNoodles() {
        log.info("恰面条");
    }

}
