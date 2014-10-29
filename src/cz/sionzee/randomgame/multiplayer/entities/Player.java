package cz.sionzee.randomgame.multiplayer.entities;

/**
 * Created by sionzee on 29. 10. 2014.
 */
public class Player implements LiveEntity {
    String name;
    private final int maxHealth = 100;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return maxHealth;
    }
}
