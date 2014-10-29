package cz.sionzee.randomgame.multiplayer.event;

/**
 * Created by sionzee on 29. 10. 2014.
 */
public class EventError {

    String message;

    public boolean hasError() {
        return message.length() != 0;
    }

    public EventError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
