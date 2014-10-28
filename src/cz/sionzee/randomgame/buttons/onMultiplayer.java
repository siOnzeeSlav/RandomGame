package cz.sionzee.randomgame.buttons;

import cz.sionzee.randomgame.network.TCPJoin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sionzee on 28. 10. 2014.
 */
public class onMultiplayer implements ActionListener {

    JButton create;
    JButton join;
    JTextField ip;

    @Override
    public void actionPerformed(ActionEvent e) {
        create = new JButton("Create Game");
        create.addActionListener((action) -> {

        });
        join = new JButton("Join Game");
        join.addActionListener((action) -> {
            if(ip.getText().length() != 0) {
                new TCPJoin(ip.getText());
            }
        });
        ip = new JTextField("127.0.0.1");
    }
}
