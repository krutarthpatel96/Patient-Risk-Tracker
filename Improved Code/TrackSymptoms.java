package edu.ipa.pandemic;

import java.util.ArrayList;
import java.util.List;

import edu.ipa.pandemic.Enums.Symptom;

public class TrackSymptoms {
    public static TrackSymptoms symptomsTracker;
    private List<Symptom> symptomsList = new ArrayList<Symptom>();

    private TrackSymptoms() {
    }

    public static TrackSymptoms instance() {
        if (symptomsTracker == null) {
            symptomsTracker = new TrackSymptoms();
        }
        return symptomsTracker;
    }

    public void setSymptomsList(List<Symptom> symptomsList) {
        this.symptomsList = symptomsList;
    }

    public boolean hasCough() {
        return symptomsList.contains(Symptom.COUGH);
    }

    public boolean hasFever() {
        return symptomsList.contains(Symptom.FEVER);
    }

    public boolean hasDifficultyBeathing() {
        return symptomsList.contains(Symptom.DIFFICULTY_BREATHING);
    }

    public boolean hasPneumoniaInBothLungs() {
        return symptomsList.contains(Symptom.PNEUMONIA_IN_BOTH_LUNGS);
    }

    public int getSymptomsCount() {
        return symptomsList.size();
    }
}
