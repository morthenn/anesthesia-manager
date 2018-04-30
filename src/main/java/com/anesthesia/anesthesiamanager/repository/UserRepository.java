package com.anesthesia.anesthesiamanager.repository;

import com.anesthesia.anesthesiamanager.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Michal-morthenn on 16/10/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findById(Long id);
    List<User> findByUsername(String username);
    boolean existsByUsername(String username);


}
