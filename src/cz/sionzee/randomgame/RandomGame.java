package cz.sionzee.randomgame;

import cz.sionzee.randomgame.thread.MyListener;
import cz.sionzee.randomgame.thread.MyThread;

import javax.swing.*;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by sionzee on 28. 10. 2014.
 */
public class RandomGame {

    private static MainMenuFrame mainFrame;

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("APPy START: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
        mainFrame = new MainMenuFrame(true);
    }

    public static MainMenuFrame getMainMenuFrame() {
        return mainFrame;
    }

    public static final HashMap<String, MyThread> threads_dones = new HashMap<String, MyThread>();
    public static final HashMap<String, MyThread> threads = new HashMap<String, MyThread>();

    public static void newThread(String name, MyListener listener) {
        MyThread myT = new MyThread(name, listener);
        threads.put(name, myT);
        myT.start();
    }

    public static void threadDispose(MyThread thread) {
        if(threads.containsKey(thread.getName())) {
            if (thread.isDone()) {
                threads_dones.put(thread.getName(), thread);
                threads.remove(thread.getName());
            }
        }
    }

    public static void threadDispose(String name) {
        if(threads.containsKey(name)) {
            MyThread mt = threads.get(name);
            if (mt.isDone()) {
                threads_dones.put(name, mt);
                threads.remove(name);
            }
        }
    }

    public static void setFullScreen(boolean fullScreen) {
        if(fullScreen)
            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        else
            mainFrame.setExtendedState(JFrame.NORMAL);
        mainFrame.setVisible(true);
    }
}
