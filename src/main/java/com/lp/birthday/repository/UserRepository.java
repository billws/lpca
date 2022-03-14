package com.lp.birthday.repository;

import com.lp.birthday.entity.users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<users, Long> {
    @Query(value="SELECT * FROM users WHERE MONTH(Date_Of_Birth) = ?1 AND DAYOFMONTH(Date_Of_Birth) = ?2" ,nativeQuery = true)
    List<users> findByBirthDay(int month, int day);
}
