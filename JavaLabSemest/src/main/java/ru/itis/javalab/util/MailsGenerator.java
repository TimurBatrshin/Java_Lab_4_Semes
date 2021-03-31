package ru.itis.javalab.util;

/**
 * 15.02.2021
 * 19. spring-boot-demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface MailsGenerator {
    String getMailForConfirm(String serverUrl, String code);
}
