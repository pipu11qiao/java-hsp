package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MailService {
    @Autowired(required = false)
    private ZoneId zoneId = ZoneId.systemDefault();

//    @PostConstruct
//    public void init() {
//        System.out.println("Init mail service with zoneId= " + this.zoneId);
//    }
//
//    @PreDestroy
//    public void shutdown() {
//        System.out.println("Shutdown mail service");
//    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public String getTime() {
        return ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    public void sendLoginMail(User user) {
        System.out.println(String.format("Hi %s! you are logged in at %s", user.getName(), getTime()));
    }

    public void sendRegistrationMail(User user) {
        System.out.println(String.format("Welcome, %S", user.getName()));
    }
}


