package com.lp.birthday.service;

import java.util.List;

import com.lp.birthday.entity.users;
import com.lp.birthday.model.BirthMsg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Female")
public class FemaleGenderImpl implements Igender {

    public final static String genderType = "Female";

    @Value("${lpac.service.subject-msg}")
    private String subjectMsg;

    @Value("${lpac.service.title-msg}")
    private String titleMsg;

    @Value("${lpac.service.female-msg}")
    private String additionalMsg;

    @Override
    public void buildBirthMsg(users user, List<BirthMsg> result) {
        if (user.getGender().equals(FemaleGenderImpl.genderType)) {
            result.add(new BirthMsg(subjectMsg, String.format(titleMsg, user.getFirstName(), additionalMsg)));
        }
    }
}
