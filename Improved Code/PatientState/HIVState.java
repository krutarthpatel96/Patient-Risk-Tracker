package edu.ipa.pandemic.PatientState;

import edu.ipa.pandemic.AbstractFactory;
import edu.ipa.pandemic.IAbstractFactory;
import edu.ipa.pandemic.TrackRiskModifiers;
import edu.ipa.pandemic.TrackSymptoms;
import edu.ipa.pandemic.Enums.RiskLevel;

public class HIVState extends State {
    private IAbstractFactory abstractFactory;
    private TrackRiskModifiers riskModifiersTracker;
    private TrackSymptoms symptomsTracker;

    public HIVState() {
        abstractFactory = AbstractFactory.instance();
        riskModifiersTracker = TrackRiskModifiers.instance();
        symptomsTracker = TrackSymptoms.instance();
    }

    @Override
    public RiskLevel handle(RiskLevel level) {
        this.nextState = abstractFactory.getAgedOrAsthmaticState();
        if (hasHIVRiskModifier() && hasTravelRiskModifiers()) {
            this.nextState = null;
            if (hasRequiredSymptoms()) {
                return RiskLevel.EMERGENT;
            } else {
                return RiskLevel.URGENT;
            }
        }
        return level;
    }

    private boolean hasHIVRiskModifier() {
        return riskModifiersTracker.hasHIV();
    }

    private boolean hasTravelRiskModifiers() {
        return (riskModifiersTracker.hasTravelled() || riskModifiersTracker.hasInteractedWithTraveller());
    }

    private boolean hasRequiredSymptoms() {
        return (symptomsTracker.hasCough() || symptomsTracker.hasFever());
    }
}