package com.lp.birthday.service;

import com.lp.birthday.entity.users;

import java.time.LocalDate;
import java.util.List;
import com.lp.birthday.entity.users;
import com.lp.birthday.model.BirthMsg;

public interface Ielder {
    void buildBirthMsg(users user, List<BirthMsg> result, LocalDate date);
}
