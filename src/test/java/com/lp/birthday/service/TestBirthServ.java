package com.lp.birthday.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.lp.birthday.entity.users;
import com.lp.birthday.model.BirthMsg;
import com.lp.birthday.repository.UserRepository;
import com.lp.birthday.service.Ibirth;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

@SpringBootTest
@ActiveProfiles("test")
public class TestBirthServ {

    @Value("${lpac.service.subject-msg}")
    private String subjectMsg;

    @Value("${lpac.service.content-msg}")
    private String contentMsg;

    @Value("${lpac.service.elder-age}")
    private String elderAge;

    @Value("${lpac.service.elder-pic}")
    private String elderPicture;
    
    @Autowired
    private Ibirth birthService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testGetNothing() {
        List<users> fakeUsersList = new ArrayList<users>();

        LocalDate localDate = LocalDate.now();

        Mockito.when(userRepository.findByBirthDay(3, 14)).thenReturn(fakeUsersList);

        List<BirthMsg> actualUsersList = birthService.getBirthByDate(localDate);
        List<BirthMsg> expectedUsersList = new ArrayList<BirthMsg>();

        assertEquals(0, actualUsersList.size());
        assertEquals(expectedUsersList, actualUsersList);
    }

    @Test
    public void testGetOne() {
        List<users> fakeUsersList = new ArrayList<users>();
        users user = new users();
        user.setID(3L);
        user.setFirstName("Miki");
        user.setLastName("Lai");
        user.setEmail("miki.lai@corp.com");
        user.setGender("Female");
        String birStr = "1950-04-05";
        Date date = Date.valueOf(birStr);
        user.setDateOfBirth(date);
        fakeUsersList.add(user);
        users user2 = new users();
        user2.setID(3L);
        user2.setFirstName("Sherry");
        user2.setLastName("Chen");
        user2.setEmail("sherry.chen@corp.com");
        user2.setGender("Male");
        String birStr2 = "1993-04-05";
        Date date2 = Date.valueOf(birStr2);
        user2.setDateOfBirth(date2);
        fakeUsersList.add(user2);

        LocalDate localDate = LocalDate.of(2022, 3, 14);

        Mockito.when(userRepository.findByBirthDay(3, 14)).thenReturn(fakeUsersList);

        List<BirthMsg> actualUsersList = birthService.getBirthByDate(localDate);
        List<BirthMsg> expectedUsersList = new ArrayList<BirthMsg>();
        expectedUsersList.add(new BirthMsg(subjectMsg, String.format(contentMsg, user.getFirstName()), elderPicture));
        //expectedUsersList.add(new BirthMsg(subjectMsg, String.format(contentMsg, user.getFirstName()), elderPicture));

        assertEquals(expectedUsersList.size(), actualUsersList.size());
        assertEquals(expectedUsersList.get(0).getSubject(), actualUsersList.get(0).getSubject());
        //assertEquals(expectedUsersList.get(1).getSubject(), actualUsersList.get(1).getSubject());
        assertEquals(expectedUsersList.get(0).getContent(), actualUsersList.get(0).getContent());
        //assertEquals(expectedUsersList.get(1).getContent(), actualUsersList.get(1).getContent());
    }

}
