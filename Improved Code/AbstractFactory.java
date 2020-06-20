package edu.ipa.pandemic;

import edu.ipa.pandemic.PatientState.AgedOrAsthmaticState;
import edu.ipa.pandemic.PatientState.HIVState;
import edu.ipa.pandemic.PatientState.PregnantState;
import edu.ipa.pandemic.PatientState.State;
import edu.ipa.pandemic.PatientState.TravelState;

public class AbstractFactory implements IAbstractFactory {
    private static AbstractFactory abstractFactory;

    private AbstractFactory() {
    }

    public static IAbstractFactory instance() {
        if (abstractFactory == null) {
            abstractFactory = new AbstractFactory();
        }
        return abstractFactory;
    }

    @Override
    public State getTravelState() {
        return new TravelState();
    }

    @Override
    public State getPregnantState() {
        return new PregnantState();
    }

    @Override
    public State getHIVState() {
        return new HIVState();
    }

    @Override
    public State getAgedOrAsthmaticState() {
        return new AgedOrAsthmaticState();
    }
}
