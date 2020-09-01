package priv.wmc.study.other;

import java.awt.*;
import java.awt.event.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2020-07-21 20:42:03
 */
@Slf4j
class PingTu {

    public static void main(String args[]) {
        MianBan mb = new MianBan(200, 200);

        Button[] b = mb.getButtonArray();
        for (int i = 1; i < 9; i++) {
            log.info(b[i].getLabel());
        }
    }
}
