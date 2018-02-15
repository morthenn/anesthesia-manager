package com.anesthesia.anesthesiamanager.utils.fields;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
public enum AsaRank {
    ONE("1"),
    ONE_E("1E"),
    TWO("2"),
    TWO_E("2E"),
    THREE("3"),
    THREE_E("3E"),
    FOUR("4"),
    FOUR_E("4E"),
    FIVE("5"),
    FIVE_E("5E");

    private String fieldDescription;

    AsaRank(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

}
