package cz.sionzee.randomgame.runnables;

import cz.sionzee.randomgame.RandomGame;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by sionzee on 28. 10. 2014.
 */
public class GameThread extends Canvas implements Runnable{

    long currentTime;
    long deltaTime;
    long lastTime;

    @Override
    public void run() {
        System.out.println(Arrays.toString(RandomGame.getMainMenuFrame().getComponents()));
        Component[] components = RandomGame.getMainMenuFrame().getComponents();
        for(Component c : components) {
            RandomGame.getMainMenuFrame().remove(c);
        }

        System.out.println(Arrays.toString(RandomGame.getMainMenuFrame().getComponents()));
        setBackground(Color.black);
        setSize(RandomGame.getMainMenuFrame().width, RandomGame.getMainMenuFrame().height);
        RandomGame.getMainMenuFrame().add(this);
        RandomGame.getMainMenuFrame().repaint();

        RandomGame.setFullScreen(true);
        while(true) {
            invalidate();
            currentTime = System.currentTimeMillis();
            deltaTime = currentTime - lastTime;

            //if(lastTime != 0)
                tick(deltaTime);

            lastTime = System.currentTimeMillis();
        }
    }

    public void tick(long time) {
        Graphics graphics = getGraphics();
        graphics.setColor(Color.white);
        graphics.drawString("Tick: " + time, 0, 0);
    }

}
