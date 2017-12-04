package com.anesthesia.anesthesiamanager.model;

import com.anesthesia.anesthesiamanager.utils.Period;
import com.anesthesia.anesthesiamanager.utils.fields.AsaRank;
import com.anesthesia.anesthesiamanager.utils.fields.Supervision;
import com.anesthesia.anesthesiamanager.utils.fields.Technique;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */

@Entity
@Table
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private int evidentialNumber;
    @NotNull
    private LocalDateTime registerDate;

    private String age;
    private AsaRank asaRank;
    private Supervision supervision;
    private Technique technique;
    private String treatmentDetails;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //Jpa only
    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int patientAge, Period timePeriod) {
        switch (timePeriod) {
            case WEEK:
                if (patientAge == 1) {
                    this.age = "1 tydzień";
                    break;
                } else if (patientAge < 4) {
                    this.age = patientAge + " tygodnie";
                    break;
                }
            case MONTH:
                if (patientAge == 1) {
                    this.age = "1 miesiąc";
                    break;
                } else if (patientAge > 1 && patientAge < 5) {
                    this.age = patientAge + " miesiące";
                    break;
                } else if (patientAge < 12) {
                    this.age = patientAge + " miesięcy";
                    break;
                }
            case YEAR:
                if (patientAge == 1) {
                    this.age = "1 rok";
                    break;
                } else if (patientAge > 1 && patientAge < 5) {
                    this.age = patientAge + " lata";
                    break;
                } else if (patientAge < 120) {
                    this.age = patientAge + " lat";
                    break;
                }
        }
    }

    public int getEvidentialNumber() {
        return evidentialNumber;
    }

    public void setEvidentialNumber(int evidentialNumber) {
        this.evidentialNumber = evidentialNumber;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public String getAge() {
        return age;
    }

    public AsaRank getAsaRank() {
        return asaRank;
    }

    public void setAsaRank(AsaRank asaRank) {
        this.asaRank = asaRank;
    }

    public Supervision getSupervision() {
        return supervision;
    }

    public void setSupervision(Supervision supervision) {
        this.supervision = supervision;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
