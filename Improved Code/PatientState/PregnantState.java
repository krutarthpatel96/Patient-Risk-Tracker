package edu.ipa.pandemic.PatientState;

import edu.ipa.pandemic.AbstractFactory;
import edu.ipa.pandemic.IAbstractFactory;
import edu.ipa.pandemic.TrackRiskModifiers;
import edu.ipa.pandemic.TrackSymptoms;
import edu.ipa.pandemic.Enums.RiskLevel;

public class PregnantState extends State {
    private IAbstractFactory abstractFactory;
    private TrackRiskModifiers riskModifiersTracker;
    private TrackSymptoms symptomsTracker;

    public PregnantState() {
        abstractFactory = AbstractFactory.instance();
        riskModifiersTracker = TrackRiskModifiers.instance();
        symptomsTracker = TrackSymptoms.instance();
    }

    @Override
    public RiskLevel handle(RiskLevel level) {
        this.nextState = abstractFactory.getHIVState();
        if (hasPregnantRiskModifiers() && hasRequiredSymptoms()) {
            this.nextState = null;
            return RiskLevel.LESS_URGENT;
        }
        return level;
    }

    private boolean hasPregnantRiskModifiers() {
        return riskModifiersTracker.isPregnant();
    }

    private boolean hasRequiredSymptoms() {
        boolean hasCough = symptomsTracker.hasCough();
        boolean noFever = (symptomsTracker.hasFever() == false);
        return (hasCough && noFever);
    }
}
