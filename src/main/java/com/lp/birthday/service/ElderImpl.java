package com.lp.birthday.service;

import java.time.LocalDate;
import java.util.List;

import com.lp.birthday.entity.users;
import com.lp.birthday.model.BirthMsg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElderImpl implements Ielder {

    private final static int DefaultAge = 49;

    @Value("${lpac.service.subject-msg}")
    private String subjectMsg;

    @Value("${lpac.service.content-msg}")
    private String contentMsg;

    @Value("${lpac.service.elder-age}")
    private String elderAge;

    @Value("${lpac.service.elder-pic}")
    private String elderPicture;

    @Override
    public void buildBirthMsg(users user, List<BirthMsg> result, LocalDate date) {
        int systemYear = date.getYear();
        int userYear = user.getDateOfBirth().toLocalDate().getYear();
        int ageLimit = 0;
        try {
            ageLimit = Integer.parseInt(elderAge, 10);
        } catch (NumberFormatException ex) {
            System.out.println("Elder age format incorrect.");
            ageLimit = DefaultAge;
        }
        if (systemYear - userYear >= ageLimit) {
            result.add(new BirthMsg(subjectMsg, String.format(contentMsg, user.getFirstName()), elderPicture));
        }
    }

}
