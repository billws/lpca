package com.lp.birthday.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.lp.birthday.service.Ibirth;
import com.lp.birthday.model.BirthMsg;
import com.lp.birthday.util.TimeParse;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Birthday")
public class BirthdayController {

    @Autowired
    private Ibirth birthService;

    @GetMapping("/Get")
    public List<BirthMsg> GetBirthday(@RequestParam(name = "date", required = false) String date) {
        LocalDate today = LocalDate.now();
        if (null != date && !date.equals("")) {
            today = TimeParse.parseToLocalDate(date);
        }
        return birthService.getBirthByDate(today);
    }
}