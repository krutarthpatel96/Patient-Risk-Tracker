package edu.ipa.pandemic;

import java.util.List;

// DO NOT MODIFY THIS FILE IN ANY WAY
public interface IRiskAssessor
{
	public RiskLevel assess(List<Symptom> symptoms, List<RiskModifier> riskModifiers);
}
