package cz.sionzee.randomgame.multiplayer.event;

/**
 * Created by sionzee on 29. 10. 2014.
 */
public interface Executor {
    REPriority priority();
    void execute();
}
