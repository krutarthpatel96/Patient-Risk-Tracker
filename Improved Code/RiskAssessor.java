package edu.ipa.pandemic;

import java.util.List;

import edu.ipa.pandemic.Enums.RiskLevel;
import edu.ipa.pandemic.Enums.RiskModifier;
import edu.ipa.pandemic.Enums.Symptom;
import edu.ipa.pandemic.PatientState.State;

public class RiskAssessor implements IRiskAssessor {
    private IAbstractFactory abstractFactory;
    private RiskLevel level;
    private State currentState;
    private TrackRiskModifiers trackRiskModifiers;
    private TrackSymptoms trackSymptoms;

    @Override
    public RiskLevel assess(List<Symptom> symptoms, List<RiskModifier> riskModifiers) {
        abstractFactory = AbstractFactory.instance();
        trackRiskModifiers = TrackRiskModifiers.instance();
        trackSymptoms = TrackSymptoms.instance();
        trackRiskModifiers.setRiskModifierList(riskModifiers);
        trackSymptoms.setSymptomsList(symptoms);
        currentState = abstractFactory.getTravelState();
        level = RiskLevel.NON_URGENT;

        do {
            level = currentState.handle(level);
            currentState = currentState.nextState;
        } while (currentState != null);

        return level;
    }
}
