package cz.sionzee.randomgame.dialogs;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by sionzee on 28. 10. 2014.
 */
public class DialogEntity {

    public static final HashMap<String, DialogEntity> entities = new HashMap<String, DialogEntity>();
    private static DialogEntity lastDialogEntity = null;

    public DialogEntity(int id, JFrame instance, JPanel panel) {
        this.id = id;
        this.pointer = instance;
        Component[] components = instance.getComponents();
        for(int i = 0; i < components.length; i++) {
            Component c = components[i];
            if(c.getName() == "Dialog_" + id) {
                component = c;
                break;
            }
        }
        lastDialogEntity = this;
        entities.put("Dialog_" + id, this);
    }

    public static DialogEntity getLastDialogEntity() {
        return lastDialogEntity;
    }

    public void dispose() {
        pointer.remove(component);
    }

    public int getId() {
        return id;
    }

    private JFrame pointer;
    private Component component;
    private int id;

    public static DialogEntity getDialogEntityByName(String name) {
        return entities.get("Dialog_" + name);
    }

}
