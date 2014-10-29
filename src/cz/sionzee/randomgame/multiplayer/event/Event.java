package cz.sionzee.randomgame.multiplayer.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sionzee on 29. 10. 2014.
 */
public abstract class Event {

    HashMap<String, List<IEvent>> iEventHandler = new HashMap<String, List<IEvent>>();

    public void addListener(String eventName, IEvent ie) {
        List<IEvent> listen = null;
        if(iEventHandler.containsKey(eventName))
            listen = iEventHandler.get(eventName);
        else listen = new ArrayList<IEvent>();

        listen.add(ie);
        iEventHandler.put(eventName, listen);
    }

    public List<IEvent> getListeners(String event) {
        return iEventHandler.get(event);
    }

}
