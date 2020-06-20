package edu.ipa.pandemic;

public class Factory {
    public static IRiskAssessor makeAssessor() {
        return new RiskAssessor();
    }
}
