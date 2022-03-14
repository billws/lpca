package com.lp.birthday.service;

import java.sql.Date;
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
public class TestGenderServ {

    @Value("${lpac.service.subject-msg}")
    private String subjectMsg;

    @Value("${lpac.service.title-msg}")
    private String titleMsg;

    @Value("${lpac.service.male-msg}")
    private String maleMsg;

    @Value("${lpac.service.female-msg}")
    private String femaleMsg;
    
    @Autowired
    @Qualifier("Male")
    private Igender maleService;

    @Autowired
    @Qualifier("Female")
    private Igender femaleService;


    
    @Test
    public void testFemale() {
        users user = new users();
        user.setID(3L);
        user.setFirstName("Miki");
        user.setLastName("Lai");
        user.setEmail("miki.lai@corp.com");
        user.setGender("Female");
        String birStr = "1993-04-05";
        Date date = Date.valueOf(birStr);
        user.setDateOfBirth(date);

        BirthMsg expected = new BirthMsg(subjectMsg, String.format(titleMsg, user.getFirstName(), femaleMsg));
        List<BirthMsg> actualUsersList = new ArrayList<BirthMsg>();
        femaleService.buildBirthMsg(user, actualUsersList);
        
        assertEquals(expected.getSubject(), actualUsersList.get(0).getSubject());
        assertEquals(expected.getContent(), actualUsersList.get(0).getContent());
    }

    @Test
    public void testMale() {
        users user = new users();
        user.setID(3L);
        user.setFirstName("Miki");
        user.setLastName("Lai");
        user.setEmail("miki.lai@corp.com");
        user.setGender("Male");
        String birStr = "1993-04-05";
        Date date = Date.valueOf(birStr);
        user.setDateOfBirth(date);

        BirthMsg expected = new BirthMsg(subjectMsg, String.format(titleMsg, user.getFirstName(), maleMsg));
        List<BirthMsg> actualUsersList = new ArrayList<BirthMsg>();
        maleService.buildBirthMsg(user, actualUsersList);
        
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

        BirthMsg expected = new BirthMsg(subjectMsg, String.format(titleMsg, user.getFirstName(), femaleMsg));
        List<BirthMsg> actualUsersList = new ArrayList<BirthMsg>();
        femaleService.buildBirthMsg(user, actualUsersList);
        
        assertEquals(0, actualUsersList.size());
    }
    
    

}
