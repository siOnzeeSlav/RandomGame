package cz.sionzee.randomgame;

import cz.sionzee.randomgame.buttons.onExit;
import cz.sionzee.randomgame.buttons.onMultiplayer;
import cz.sionzee.randomgame.buttons.onNewGame;
import cz.sionzee.randomgame.dialogs.DialogEntity;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class MainMenuFrame extends JFrame {

    public int width;
    public int height;

    private boolean initialized = false;

    public MainMenuFrame(boolean visibility) {
        initialize();
        super.setVisible(visibility);
    }

    private void initialize() {
        if (initialized)
            return;
        initialized = true;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        setSize(width, height);
        this.width = width;
        this.height = height;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton newGamebtn = new JButton("New Game");
        newGamebtn.addActionListener(new onNewGame());

        JButton multiplayerbtn = new JButton("Multiplayer");
        multiplayerbtn.addActionListener(new onMultiplayer());

        JButton exitbtn = new JButton("Exit");
        exitbtn.addActionListener(new onExit());

        JPanel container = new JPanel();
        container.add(newGamebtn);
        container.add(multiplayerbtn);
        container.add(exitbtn);
        setLayout(new GridBagLayout());
        add(container, new GridBagConstraints());
    }

    public DialogEntity ShowDialog(String dialogTitle, String dialogText, JPanel content) {
        JPanel jPanel = new JPanel(new GridBagLayout());
        int id = new Random().nextInt(10000);
        jPanel.setName("Dialog_" + id);
        GridBagConstraints c = new GridBagConstraints();
        jPanel.setSize(width / 2, height / 2);

        JLabel title = new JLabel(dialogTitle);
        JLabel text = new JLabel(dialogText);

        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        jPanel.add(title, c);
        c.gridy = 1;
        jPanel.add(text, c);
        c.gridy = 2;
        jPanel.add(content, c);

        add(jPanel);
        repaint();
        return new DialogEntity(id, this, jPanel);
    }

    public void dispose() {
        System.exit(0);
    }
}