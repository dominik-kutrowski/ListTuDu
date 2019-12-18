package com.ListTuDu;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    @Transactional
    @Modifying
    @Query("Update User ul SET ul.pass = ?1 WHERE ul.email = ?2")
    void updateByPassWhereEmail(String pass, String email);
}
