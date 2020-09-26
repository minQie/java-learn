package priv.wmc.study.jdk8.interface_default_method;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2019-08-24 16:21
 */
public interface One {

    default void howMuch() {
        System.out.println(1);
    }

}
