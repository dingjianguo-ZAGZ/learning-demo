package com.su.test.C7immutable;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Slf4j(topic = "c.dataTimeFormatter")
public class TestDateTimeFormatter {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                LocalDate date = dtf.parse("2022-10-15", LocalDate::from);
                log.debug("{}",date);
                DateTimeFormatter out = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                String dateString = out.format(date);
                log.debug("{}",dateString);
            },""+i).start();
        }
    }
}
