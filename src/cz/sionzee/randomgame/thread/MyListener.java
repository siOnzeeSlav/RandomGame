package cz.sionzee.randomgame.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sionzee on 28. 10. 2014.
 */
public abstract class MyListener {

    boolean close = false;
    public final List<MyListenerEntity> toDo = new ArrayList<MyListenerEntity>();
    int last;

    public void add(MyListenerEntity ent) {
        toDo.add(ent);
        last = ent.hashCode();
    }

    public void Do() {
        toDo.stream().forEach((mle) -> {
            if(mle.hashCode() == last) {
                close = true;
            }
            mle.Do();
            toDo.remove(mle);
        });
    }

    public boolean close() {
        return close;
    }

}
