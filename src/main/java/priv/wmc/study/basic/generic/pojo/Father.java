package priv.wmc.study.basic.generic.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * Simple POJO AS Child
 * @author Wang Mincong
 * @date 2019-08-09 12:42
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = true)
public class Father extends GrandFather {

    private String username;

    public Father() {
        this.username = "未初始化";
    }

    public Father(String username) {
        this.username = username;
    }

    public static void whoScream() {
        log.info("啊...");
    }

    public static void screamByUser(Father user) {
        log.info(user.getUsername() + "啊...");
    }

    public void scream() {
        log.info("啊...");
    }

    public void substitudeScream(Father user) {
        log.info(this.username + " 替 " + user.getUsername() + "：啊...");
    }


}
