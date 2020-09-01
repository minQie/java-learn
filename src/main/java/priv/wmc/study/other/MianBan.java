package priv.wmc.study.other;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Wang Mincong
 * @date 2020-06-14 18:29:14
 */
class MianBan {

    Button b[] = new Button[9];
    private Frame f = new Frame("ƴͼ");

    MianBan(int x, int y) {
        init(x, y);
        myEvent();
    }

    private void init(int x, int y) {
        f.setSize(x, y);
        f.setLocation(300, 200);
        f.setLayout(new GridLayout());
        for (int i = 1; i < 9; i++) {
            b[i] = new Button(String.valueOf(i));
            f.add(b[i]);
        }

        f.setVisible(true);
    }

    private void myEvent() {
        f.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        for (int i = 1; i < 9; i++) {
            b[i].addActionListener(e -> {});
        }
    }

    public Frame getFrame() {
        return f;
    }

    public Button[] getButtonArray() {
        return b;
    }
}
