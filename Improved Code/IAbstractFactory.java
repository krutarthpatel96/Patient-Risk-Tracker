package edu.ipa.pandemic;

import edu.ipa.pandemic.PatientState.State;

public interface IAbstractFactory {

    public State getTravelState();

    public State getPregnantState();

    public State getHIVState();

    public State getAgedOrAsthmaticState();

}
