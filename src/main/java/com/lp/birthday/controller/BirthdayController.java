package com.lp.birthday.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.lp.birthday.service.Ibirth;
import com.lp.birthday.model.BirthMsgs;
import com.lp.birthday.util.TimeParse;
import java.time.LocalDate;

@RestController
@RequestMapping("/Birthday")
public class BirthdayController {

    @Autowired
    private Ibirth birthService;

    @GetMapping(value = "/Get", produces = { MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public BirthMsgs GetBirthday(@RequestParam(name = "date", required = false) String date) {
        LocalDate today = LocalDate.now();
        if (null != date && !date.equals("")) {
            today = TimeParse.parseToLocalDate(date);
        }
        BirthMsgs result = new BirthMsgs(birthService.getBirthByDate(today));
        return result;
    }
}