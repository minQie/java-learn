package priv.wmc.study.senior.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2020-02-03 16:52
 */
@Slf4j
public class EatInterfaceImpl implements EatInterface {

    @Override
    public void eatRice() {
        log.info("吃饭");
    }

    @Override
    public void eatNoodles() {
        log.info("吃面");
    }

}
