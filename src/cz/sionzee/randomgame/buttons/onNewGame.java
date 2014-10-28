package cz.sionzee.randomgame.buttons;

import cz.sionzee.randomgame.runnables.GameThread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sionzee on 28. 10. 2014.
 */
public class onNewGame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("NewGame");
        new Thread(new GameThread()).run();
    }
}
