package edu.ipa.pandemic.PatientState;

import edu.ipa.pandemic.TrackRiskModifiers;
import edu.ipa.pandemic.TrackSymptoms;
import edu.ipa.pandemic.Enums.RiskLevel;

public class AgedOrAsthmaticState extends State {
    private TrackRiskModifiers riskModifiersTracker;
    private TrackSymptoms symptomsTracker;

    public AgedOrAsthmaticState() {
        riskModifiersTracker = TrackRiskModifiers.instance();
        symptomsTracker = TrackSymptoms.instance();
    }

    @Override
    public RiskLevel handle(RiskLevel level) {
        this.nextState = null;
        if (hasAgeOrAsthmaRiskModifiers() && meetsSymptomsThreshold()) {
            if (hasTravelRiskModifiers()) {
                return RiskLevel.RESUSCITATION;
            } else {
                return RiskLevel.URGENT;
            }
        }
        return level;
    }

    private boolean hasAgeOrAsthmaRiskModifiers() {
        return (riskModifiersTracker.isOlderThan65() || riskModifiersTracker.hasAsthma());
    }

    public boolean meetsSymptomsThreshold() {
        int symptomsThreshold = 2;
        int totalSymptoms = symptomsTracker.getSymptomsCount();
        return (totalSymptoms >= symptomsThreshold);
    }

    private boolean hasTravelRiskModifiers() {
        return (riskModifiersTracker.hasTravelled() || riskModifiersTracker.hasInteractedWithTraveller());
    }
}
