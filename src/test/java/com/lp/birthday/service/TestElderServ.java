package com.lp.birthday.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lp.birthday.entity.users;
import com.lp.birthday.model.BirthMsg;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@ActiveProfiles("test")
public class TestElderServ {

    @Value("${lpac.service.subject-msg}")
    private String subjectMsg;

    @Value("${lpac.service.content-msg}")
    private String contentMsg;

    @Value("${lpac.service.elder-age}")
    private String elderAge;

    @Value("${lpac.service.elder-pic}")
    private String elderPicture;
    
    @Autowired
    private Ielder elderService;


    
    @Test
    public void testelder() {
        users user = new users();
        user.setID(3L);
        user.setFirstName("Miki");
        user.setLastName("Lai");
        user.setEmail("miki.lai@corp.com");
        user.setGender("Female");
        String birStr = "1950-04-05";
        Date date = Date.valueOf(birStr);
        user.setDateOfBirth(date);

        LocalDate inputDate = LocalDate.of(2022, 3, 15);

        BirthMsg expected = new BirthMsg(subjectMsg, String.format(contentMsg, user.getFirstName()), elderPicture);
        List<BirthMsg> actualUsersList = new ArrayList<BirthMsg>();
        elderService.buildBirthMsg(user, actualUsersList, inputDate);
        
        assertEquals(expected.getSubject(), actualUsersList.get(0).getSubject());
        assertEquals(expected.getContent(), actualUsersList.get(0).getContent());
    }


    
    @Test
    public void testNot() {
        users user = new users();
        user.setID(3L);
        user.setFirstName("Miki");
        user.setLastName("Lai");
        user.setEmail("miki.lai@corp.com");
        user.setGender("Male");
        String birStr = "1993-04-05";
        Date date = Date.valueOf(birStr);
        user.setDateOfBirth(date);

        LocalDate inputDate = LocalDate.of(2022, 3, 15);

        BirthMsg expected = new BirthMsg(subjectMsg, String.format(contentMsg, user.getFirstName()), elderPicture);
        List<BirthMsg> actualUsersList = new ArrayList<BirthMsg>();
        elderService.buildBirthMsg(user, actualUsersList, inputDate);
        
        assertEquals(0, actualUsersList.size());
    }
    
    

}
