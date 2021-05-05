package model.cards.cardsEffect;

import model.events.Event;

import java.util.ArrayList;

public class EffectOfMagic {
    public ArrayList<Event> eventsActivateEffect;

    public void active() {
    }

    public boolean isEventActiveEffect(Event event) {
        for (Event thisEvent : eventsActivateEffect) {
            if (thisEvent.equals(event)) return true;
        }
        return false;
    }
}
