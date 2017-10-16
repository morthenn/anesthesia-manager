package com.anesthesia.anesthesiamanager.model;

import com.anesthesia.anesthesiamanager.utils.fields.AsaRank;
import com.anesthesia.anesthesiamanager.utils.fields.Supervision;
import com.anesthesia.anesthesiamanager.utils.fields.Technique;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */

//@Entity
//@Table
public class Patient {


    private int id;
    private int evidentialNumber;
    private LocalDateTime registerDate;
    private int age;
    private AsaRank asaRank;
    private Supervision supervision;
    private Technique technique;
    private String treatmentDetails;

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public int getEvidentialNumber() {
        return evidentialNumber;
    }

    public int getPatientAge() {
        return age;
    }

    public LocalDateTime getRegisteredDate() {
        return registerDate;
    }

    public AsaRank getAsa() {
        return asaRank;
    }

    public String getTreatment() {
        return treatmentDetails;
    }

    public Technique getAnesthesiaTechnique() {
        return technique;
    }

    public Supervision getSupervisionType() {
        return supervision;
    }

    public void setEvidentialNumber(int evidentialNumber) {
        this.evidentialNumber = evidentialNumber;
    }

    public void setPatientAge(int patientAge) {
        this.age = patientAge;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registerDate = registeredDate;
    }

    public void setAsaFactor(AsaRank asaFactor) {this.asaRank = asaRank;}

    public void setTreatmentType(String treatmentType) {
        this.treatmentDetails = treatmentDetails;
    }

    public void setAnesthesiaTechnique(String anesthesiaTechnique) {
        this.technique = technique;
    }

    public void setSupervisionType(String supervisionType) {
        this.supervision = supervision;
    }


}
