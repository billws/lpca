package com.lp.birthday.service;

import java.util.List;

import com.lp.birthday.entity.users;
import com.lp.birthday.model.BirthMsg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Male")
public class MaleGenderImpl implements Igender {

    public final static String genderType = "Male";

    @Value("${lpac.service.subject-msg}")
    private String subjectMsg;

    @Value("${lpac.service.title-msg}")
    private String titleMsg;

    @Value("${lpac.service.male-msg}")
    private String additionalMsg;

    @Override
    public void buildBirthMsg(users user, List<BirthMsg> result) {
        if (user.getGender().equals(MaleGenderImpl.genderType)) {
            result.add(new BirthMsg(subjectMsg, String.format(titleMsg, user.getFirstName(), additionalMsg)));
        }
    }

}
