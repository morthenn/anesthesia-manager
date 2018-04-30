package com.anesthesia.anesthesiamanager.model;

import com.anesthesia.anesthesiamanager.utils.fields.AsaRank;
import com.anesthesia.anesthesiamanager.utils.fields.Supervision;
import com.anesthesia.anesthesiamanager.utils.fields.Technique;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "id")
@Table(name = "PATIENTS")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long evidentialNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    @NotNull
    private LocalDateTime registerDate;

    @NotNull
    private String age;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AsaRank asaRank;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Supervision supervision;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Technique technique;

    @NotNull
    private String treatmentDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
//    @JsonBackReference
    @JsonIgnore
    private User user;
}
