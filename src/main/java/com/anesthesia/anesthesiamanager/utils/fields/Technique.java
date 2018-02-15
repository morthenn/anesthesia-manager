package com.anesthesia.anesthesiamanager.utils.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
public enum Technique {
    OGOLNE("og"),
    PODPAJECZYNOWKOWE("pp"),
    ZEWNATRZOPONOWE("zo"),
    BLOKADY_NERWOW("bn");

    private String fieldDescription;

    Technique(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

}
