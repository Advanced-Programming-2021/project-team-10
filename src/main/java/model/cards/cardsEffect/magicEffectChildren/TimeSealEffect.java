package model.cards.cardsEffect.magicEffectChildren;

import model.cards.cardsEffect.EffectOfMagic;
import model.events.eventChildren.ManuallyActivation;

import java.util.ArrayList;

public class TimeSealEffect extends EffectOfMagic {
    private static TimeSealEffect instance;

    {
        eventsActivateEffect = new ArrayList<>();
        eventsActivateEffect.add(ManuallyActivation.getInstance());
    }

    @Override
    public void active() {
        super.active();
    }
}
