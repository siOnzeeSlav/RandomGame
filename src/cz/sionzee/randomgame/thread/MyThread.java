package cz.sionzee.randomgame.thread;

import cz.sionzee.randomgame.RandomGame;

/**
 * Created by sionzee on 28. 10. 2014.
 */
public class MyThread extends Thread{

    MyListener listener;
    long started = 0L;
    volatile boolean running = false;

    public MyThread(String name, MyListener listener) {
        setName(name);
        this.listener = listener;
    }

    @Override
    public void run() {
        while(running) {
            listener.Do();
            if(listener.close()) {
                dispose();
            }
        }
    }

    @Override
    public void start() {
        running = true;
        started = System.currentTimeMillis();
        super.start();
    }

    public void dispose() {
        running = false;
        RandomGame.threadDispose(this);
    }

    public boolean isDone() {
        return started != 0 && !running;
    }

}
