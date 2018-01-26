package com.anesthesia.anesthesiamanager.model;

import com.anesthesia.anesthesiamanager.repository.PatientRepository;
import com.anesthesia.anesthesiamanager.utils.fields.AsaRank;
import com.anesthesia.anesthesiamanager.utils.fields.Supervision;
import com.anesthesia.anesthesiamanager.utils.fields.Technique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner{

        private final PatientRepository repository;
        @Autowired
        public DataLoader(PatientRepository repository) {
            this.repository = repository;
        }

        @Override
        @Transactional
        public void run(String... strings) throws Exception {
            User user = new User("kokokok","ajjjaja");
            this.repository.save(new Patient(666,LocalDateTime.now(), "2 lata", AsaRank.THREE, Supervision.WSPOLUDZIAL, Technique.PODPAJECZYNOWKOWE,"DOMMY",user));
            this.repository.save(new Patient(666,LocalDateTime.now(), "4 lata", AsaRank.ONE, Supervision.SAMODZIELNIE, Technique.ZEWNATRZOPONOWE,"DSDSD",user));
            this.repository.save(new Patient(666,LocalDateTime.now(), "5 lata", AsaRank.TWO, Supervision.WSPOLUDZIAL, Technique.BLOKADY_NERWOW,"FGFWFWF",user));
        }

}
