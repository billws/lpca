package com.lp.birthday.utility;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import com.lp.birthday.util.TimeParse;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class TestTimeParse {

    @Test
    public void testParseError () {
        
        LocalDate expected = LocalDate.now();
        String input = "2022-03-14";
        LocalDate result = TimeParse.parseToLocalDate(input);
        assertEquals(result, expected);
    }
    @Test
    public void testNormalParse () {
        
        LocalDate expected = LocalDate.of(2022, 03, 14);
        String input = "2022/03/14";
        LocalDate result = TimeParse.parseToLocalDate(input);
        assertEquals(result, expected);
    }
}
