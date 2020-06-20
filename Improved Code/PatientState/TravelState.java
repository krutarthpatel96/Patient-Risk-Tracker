package edu.ipa.pandemic.PatientState;

import edu.ipa.pandemic.AbstractFactory;
import edu.ipa.pandemic.IAbstractFactory;
import edu.ipa.pandemic.TrackRiskModifiers;
import edu.ipa.pandemic.TrackSymptoms;
import edu.ipa.pandemic.Enums.RiskLevel;

public class TravelState extends State {
    private IAbstractFactory abstractFactory;
    private TrackRiskModifiers riskModifiersTracker;
    private TrackSymptoms symptomsTracker;

    public TravelState() {
        abstractFactory = AbstractFactory.instance();
        riskModifiersTracker = TrackRiskModifiers.instance();
        symptomsTracker = TrackSymptoms.instance();
    }

    @Override
    public RiskLevel handle(RiskLevel level) {
        this.nextState = abstractFactory.getPregnantState();
        if (hasRequiredSymptoms()) {
            if (hasTravelRiskModifiers()) {
                this.nextState = null;
                return RiskLevel.RESUSCITATION;
            } else {
                return RiskLevel.URGENT;
            }
        }
        return level;
    }

    private boolean hasRequiredSymptoms() {
        return (symptomsTracker.hasCough()
                && symptomsTracker.hasFever()
                && symptomsTracker.hasDifficultyBeathing()
                && symptomsTracker.hasPneumoniaInBothLungs());
    }

    private boolean hasTravelRiskModifiers() {
        return (riskModifiersTracker.hasTravelled() || riskModifiersTracker.hasInteractedWithTraveller());
    }
}
