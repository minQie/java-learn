package priv.wmc.study.basic.execute.behavior;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2020-06-14 16:47:54
 */
@Slf4j
public class Parent {

    Parent() {
        fun();
    }

    void fun() {
        log.info("Parent fun");
    }

}
