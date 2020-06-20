package edu.ipa.pandemic;

import java.util.ArrayList;
import java.util.List;

import edu.ipa.pandemic.Enums.RiskModifier;

public class TrackRiskModifiers {
    public static TrackRiskModifiers riskModifiersTracker;
    private List<RiskModifier> riskModifierList = new ArrayList<RiskModifier>();

    private TrackRiskModifiers() {
    }

    public static TrackRiskModifiers instance() {
        if (riskModifiersTracker == null) {
            riskModifiersTracker = new TrackRiskModifiers();
        }
        return riskModifiersTracker;
    }

    public void setRiskModifierList(List<RiskModifier> riskModifierList) {
        this.riskModifierList = riskModifierList;
    }

    public boolean hasTravelled() {
        return riskModifierList.contains(RiskModifier.TRAVELLED);
    }

    public boolean hasInteractedWithTraveller() {
        return riskModifierList.contains(RiskModifier.INTERACTED_WITH_TRAVELLER);
    }

    public boolean isPregnant() {
        return riskModifierList.contains(RiskModifier.PREGNANT);
    }

    public boolean hasHIV() {
        return riskModifierList.contains(RiskModifier.HIV);
    }

    public boolean isOlderThan65() {
        return riskModifierList.contains(RiskModifier.OLDER_THAN_65);
    }

    public boolean hasAsthma() {
        return riskModifierList.contains(RiskModifier.ASTHMA);
    }
}
