package edu.ipa.pandemic;

import java.util.List;

import edu.ipa.pandemic.Enums.RiskLevel;
import edu.ipa.pandemic.Enums.RiskModifier;
import edu.ipa.pandemic.Enums.Symptom;

public interface IRiskAssessor {
    public RiskLevel assess(List<Symptom> symptoms, List<RiskModifier> riskModifiers);
}
