package ru.itis.springboot.util;

public interface MailsGenerator {
    String getMailForConfirm(String serverUrl, String code);
}
