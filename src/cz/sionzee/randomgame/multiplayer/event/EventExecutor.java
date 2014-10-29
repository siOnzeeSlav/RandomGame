package cz.sionzee.randomgame.multiplayer.event;

import cz.sionzee.randomgame.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sionzee on 29. 10. 2014.
 */
public class EventExecutor {

    public static EventError fireEvent(Event event) {
        List<Executor> executorList = new ArrayList<Executor>();
        event.getListeners(event.getClass().getSimpleName()).stream().forEach(ie -> {
            Method[] methods = ie.getClass().getMethods();

            for(Method method : methods) {
                RE handler = method.getAnnotation(RE.class);
                if(handler != null) {
                    Class[] methodParams = method.getParameterTypes();

                    if(methodParams.length < 1) {
                        continue;
                    }

                    if(!event.getClass().getSimpleName().equals(methodParams[0].getSimpleName())) {
                        continue;
                    }
                    executorList.add(new Executor() {
                        @Override
                        public REPriority priority() {
                            return handler.priority();
                        }

                        @Override
                        public void execute() {
                            try {
                                method.invoke(ie, event);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });

        if(executorList.size() < 1) {
            return new EventError("event = [" + event.getClass().getSimpleName() + "] don't have RE annotations");
        }

        Collections.sort(executorList, new Comparator<Executor>() {
            @Override
            public int compare(Executor o1, Executor o2) {
                return o1.priority().compareTo(o2.priority());
            }
        });

        executorList.stream().forEach(ex -> {
            Log.log("event = [" + ex.getClass().getSimpleName() + ", " + ex.priority() + "] executed");
            ex.execute();
        });

        return new EventError("");
    }

}
