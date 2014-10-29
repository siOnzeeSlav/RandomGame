package cz.sionzee.randomgame.multiplayer.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by sionzee on 29. 10. 2014.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RE {

    REPriority priority() default REPriority.NORMAL;
}
