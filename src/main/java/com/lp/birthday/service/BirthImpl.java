package com.lp.birthday.service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.lp.birthday.model.BirthMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.lp.birthday.entity.users;
import com.lp.birthday.repository.UserRepository;

@Service
public class BirthImpl implements Ibirth {

    @Value("${lpac.service.return-msg}")
    private String returnMsg;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BirthMsg> getBirthByDate(LocalDate date) {
        List<BirthMsg> result = new ArrayList<BirthMsg>();
        List<users> birthUsers = getFromDB(date);
        birthUsers.forEach(user -> convertToMsg(user, result));
        return result;
    }

    private void convertToMsg(users user, List<BirthMsg> result) {
        result.add(new BirthMsg(String.format(returnMsg, System.lineSeparator(), user.getLastName(), user.getFirstName())));
    }

    private List<users> getFromDB(LocalDate date) {
        return userRepository.findByBirthDay(date.getMonthValue(), date.getDayOfMonth());
    }

}
