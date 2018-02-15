package com.anesthesia.anesthesiamanager.utils.fields;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
public enum Supervision {
    SAMODZIELNIE("sam."),
    WSPOLUDZIAL("współ.");

    private String fieldDescription;

    Supervision(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}