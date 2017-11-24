package com.anesthesia.anesthesiamanager.model;
import com.anesthesia.anesthesiamanager.utils.fields.AsaRank;
import com.anesthesia.anesthesiamanager.utils.fields.Supervision;
import com.anesthesia.anesthesiamanager.utils.fields.Technique;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */

@Entity
@Table(name = "PATIENTS")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Min(0)
    private int evidentialNumber;

    @NotNull
    private LocalDateTime registerDate;

    @NotNull
    private int ageInMonths;
    @NotNull

    private AsaRank asaRank;
    @NotNull

    private Supervision supervision;
    @NotNull

    private Technique technique;
    @NotNul

    private String treatmentDetails;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    public Patient() {}

    public int getId() {
        return id;
    }

    public int getEvidentialNumber() {
        return evidentialNumber;
    }

    public int getPatientAge() {
        return ageInMonths;
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
        this.ageInMonths = patientAge;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registerDate = registeredDate;
    }

    public void setAsaFactor(AsaRank asaFactor) {
        this.asaRank = asaRank;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentDetails = treatmentDetails;
    }

    public void setAnesthesiaTechnique(String anesthesiaTechnique) {
        this.technique = technique;
    }

    public void setSupervisionType(String supervisionType) {
        this.supervision = supervision;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", evidentialNumber=" + evidentialNumber +
                ", registerDate=" + registerDate +
                ", months=" + ageInMonths +
                ", asaRank=" + asaRank +
                ", supervision=" + supervision +
                ", technique=" + technique +
                ", treatmentDetails='" + treatmentDetails + '\'' +
                '}';
    }
}
