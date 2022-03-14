package com.lp.birthday.service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.lp.birthday.model.BirthMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.lp.birthday.entity.users;
import com.lp.birthday.repository.UserRepository;

@Service
public class BirthImpl implements Ibirth {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("Male")
    private Igender maleService;

    @Autowired
    @Qualifier("Female")
    private Igender femaleService;

    @Override
    public List<BirthMsg> getBirthByDate(LocalDate date) {
        List<BirthMsg> result = new ArrayList<BirthMsg>();
        List<users> birthUsers = getFromDB(date);
        birthUsers.forEach(user -> convertToMsg(user, result));
        return result;
    }

    private void convertToMsg(users user, List<BirthMsg> result) {
        maleService.buildBirthMsg(user, result);
        femaleService.buildBirthMsg(user, result);
    }

    private List<users> getFromDB(LocalDate date) {
        return userRepository.findByBirthDay(date.getMonthValue(), date.getDayOfMonth());
    }

}
