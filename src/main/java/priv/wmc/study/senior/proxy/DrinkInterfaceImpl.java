package priv.wmc.study.senior.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2020-02-03 16:52
 */
@Slf4j
public class DrinkInterfaceImpl implements DrinkInterface {

    @Override
    public void drinkTea() {
        log.info("喝茶");
    }

    @Override
    public void drinkJuice() {
        log.info("喝果汁");
    }
}
