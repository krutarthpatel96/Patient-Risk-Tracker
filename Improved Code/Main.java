package edu.ipa.pandemic;

import java.util.ArrayList;
import java.util.List;

import edu.ipa.pandemic.Enums.RiskLevel;
import edu.ipa.pandemic.Enums.RiskModifier;
import edu.ipa.pandemic.Enums.Symptom;

public class Main {

    public static void main(String args[]) {
        List<Symptom> symptomList = new ArrayList<>();
        symptomList.add(Symptom.COUGH);
        symptomList.add(Symptom.DIFFICULTY_BREATHING);
        symptomList.add(Symptom.FEVER);
        symptomList.add(Symptom.PNEUMONIA_IN_BOTH_LUNGS);

        List<RiskModifier> riskModifiers = new ArrayList<>();
        riskModifiers.add(RiskModifier.TRAVELLED);
        riskModifiers.add(RiskModifier.INTERACTED_WITH_TRAVELLER);
        riskModifiers.add(RiskModifier.PREGNANT);
        riskModifiers.add(RiskModifier.HIV);
        riskModifiers.add(RiskModifier.OLDER_THAN_65);
        riskModifiers.add(RiskModifier.ASTHMA);

        IRiskAssessor assessor = Factory.makeAssessor();
        RiskLevel risk =  assessor.assess(symptomList, riskModifiers);
        System.out.println("Risk level is: " + risk);
    }

}
