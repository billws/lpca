package com.lp.birthday.service;

import com.lp.birthday.model.BirthMsg;
import java.time.LocalDate;
import java.util.List;

public interface Ibirth {
    List<BirthMsg> getBirthByDate(LocalDate date);
}
