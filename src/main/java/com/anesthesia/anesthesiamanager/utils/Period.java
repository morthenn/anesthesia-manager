package com.anesthesia.anesthesiamanager.utils;

public enum Period {
    WEEK("tygodnie"), MONTH("miesiące"), YEAR("lata");

    private String fieldDescription;

    Period(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

}
