package cz.sionzee.randomgame.buttons;

import cz.sionzee.randomgame.RandomGame;
import cz.sionzee.randomgame.dialogs.DialogEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sionzee on 28. 10. 2014.
 */
public class onExit implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel jp = new JPanel();
        JButton yesBtn = new JButton("YES");
        yesBtn.addActionListener((actionEvent) -> {DialogEntity.getLastDialogEntity().dispose(); System.exit(32);});
        JButton noBtn = new JButton("NO");
        noBtn.addActionListener((actionEvent) -> {
            DialogEntity.getLastDialogEntity().dispose();
        });
        RandomGame.getMainMenuFrame().ShowDialog("Exit Game", "Are you sure?", jp);
    }
}
