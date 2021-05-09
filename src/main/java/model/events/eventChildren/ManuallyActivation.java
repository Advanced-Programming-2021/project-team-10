package model.events.eventChildren;

import model.events.Event;

public class ManuallyActivation extends Event {
    private static ManuallyActivation instance;

    {
        name = this.getClass().getSimpleName();
    }

    public static ManuallyActivation getInstance() {
        if (instance == null) {
            instance = new ManuallyActivation();
        }
        return instance;
    }
}
