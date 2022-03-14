package com.lp.birthday.service;

import java.util.List;
import com.lp.birthday.entity.users;
import com.lp.birthday.model.BirthMsg;

public interface Igender {
    void buildBirthMsg(users user, List<BirthMsg> result);
}
