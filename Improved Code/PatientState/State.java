package edu.ipa.pandemic.PatientState;

import edu.ipa.pandemic.Enums.RiskLevel;

public abstract class State {
    public State nextState = null;

    public abstract RiskLevel handle(RiskLevel level);
}
