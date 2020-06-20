package edu.ipa.pandemic;

// From https://hopitalmontfort.com/en/canadian-triage-and-acuity-scale
public enum RiskLevel
{
	RESUSCITATION,	// Conditions that are threats to life or limb
	EMERGENT,		// Conditions that are a potential threat to life, limb or function
	URGENT,			// Serious conditions that require emergency intervention
	LESS_URGENT,	// Conditions that relate to patient distress or potential complications that benefit from intervention
	NON_URGENT		// Conditions that are non-urgent or that may be part of a chronic problem
}