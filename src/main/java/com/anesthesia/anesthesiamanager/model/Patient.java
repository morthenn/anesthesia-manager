package com.anesthesia.anesthesiamanager.model;

import com.anesthesia.anesthesiamanager.utils.fields.AsaRank;
import com.anesthesia.anesthesiamanager.utils.fields.Supervision;
import com.anesthesia.anesthesiamanager.utils.fields.Technique;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */

@Entity
@Data
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long evidentialNumber;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    @NotNull
    private LocalDateTime registerDate;

    @NotNull
    private String age;

    @NotNull
    private AsaRank asaRank;

    @NotNull
    private Supervision supervision;

    @NotNull
    private Technique technique;

    @NotNull
    private String treatmentDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    Patient(long evidentialNumber, LocalDateTime registerDate, String age, AsaRank asaRank, Supervision supervision, Technique technique, String treatmentDetails, User user) {
        this.evidentialNumber = evidentialNumber;
        this.registerDate = registerDate;
        this.age = age;
        this.asaRank = asaRank;
        this.supervision = supervision;
        this.technique = technique;
        this.treatmentDetails = treatmentDetails;
        this.user = user;
    }

    @Override
    public String toString() {
        return  "Id=" + id +
                ", Nr. ewidencyjny=" + evidentialNumber +
                ", registerDate=" + registerDate +
                ", age='" + age + '\'' +
                ", asaRank=" + asaRank +
                ", supervision=" + supervision +
                ", technique=" + technique +
                ", treatmentDetails='" + treatmentDetails + '\'' +
                ", lekarz=" + user;
    }
}
