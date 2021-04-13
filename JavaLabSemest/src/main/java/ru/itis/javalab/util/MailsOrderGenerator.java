package ru.itis.javalab.util;

import ru.itis.javalab.models.CartUser;

import java.util.List;

public interface MailsOrderGenerator {
    String getMailForOrder(String serverUrl, List<CartUser> cartUsers);
}
