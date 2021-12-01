package ru.itis.test.assertHelper;

import ru.itis.test.helpers.ApplicationManager;
import ru.itis.test.helpers.HelperBase;

public class AuthHelperAssert extends HelperBase {

    private String userName;
    private String password;

    public AuthHelperAssert(ApplicationManager manager) {
        super(manager);
    }


    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
