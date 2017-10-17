package com.anesthesia.anesthesiamanager.repository;

import com.anesthesia.anesthesiamanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
