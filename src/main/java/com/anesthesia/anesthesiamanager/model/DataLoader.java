package com.anesthesia.anesthesiamanager.model;

import com.anesthesia.anesthesiamanager.repository.PatientRepository;
import com.anesthesia.anesthesiamanager.repository.UserRepository;
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
        private final UserRepository userRepository;

        @Autowired
        public DataLoader(PatientRepository repository, UserRepository userRepository) {

            this.repository = repository;
            this.userRepository = userRepository;
        }

        @Override
        @Transactional
        public void run(String... strings) throws Exception {
            User user = new User("kokokok","ajjjaja");
            User user1 = new User("malyKokos","rogerthat");
            this.userRepository.save(user);
            this.userRepository.save(user1);
            this.repository.save(new Patient(100,LocalDateTime.now(), "2 lata", AsaRank.THREE, Supervision.WSPOLUDZIAL, Technique.PODPAJECZYNOWKOWE,"Rozentaler",user));
            this.repository.save(new Patient(145,LocalDateTime.now(), "4 lata", AsaRank.ONE, Supervision.SAMODZIELNIE, Technique.ZEWNATRZOPONOWE,"DSDSD",user));
            this.repository.save(new Patient(342,LocalDateTime.now(), "5 lata", AsaRank.TWO, Supervision.WSPOLUDZIAL, Technique.BLOKADY_NERWOW,"Mysli i slowa",user));
            this.repository.save(new Patient(132,LocalDateTime.now(), "3 lata", AsaRank.TWO, Supervision.SAMODZIELNIE, Technique.BLOKADY_NERWOW,"LOLOLOLOLO",user1));
            this.repository.save(new Patient(156,LocalDateTime.now(), "22 lata", AsaRank.FIVE_E, Supervision.WSPOLUDZIAL, Technique.ZEWNATRZOPONOWE,"KASZKIET",user));
            this.repository.save(new Patient(256,LocalDateTime.now(), "17 lata", AsaRank.TWO, Supervision.WSPOLUDZIAL, Technique.BLOKADY_NERWOW,"HEHESZEKJ",user));
        }

}
