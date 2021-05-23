package ru.itis.springboot.util;

import org.springframework.stereotype.Component;

@Component
public interface EmailUtil {
    void sendMail(String to, String subject, String from, String text);
}
