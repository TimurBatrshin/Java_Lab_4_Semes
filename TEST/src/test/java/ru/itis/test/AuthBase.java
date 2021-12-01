package ru.itis.test;

import org.junit.Before;
import ru.itis.test.helpers.ApplicationManager;

public class AuthBase extends TestBase {

    public static boolean isLogged = false;

    @Before
    public void setUp() throws Exception {
        app = ApplicationManager.getInstance();

        if (!isLogged){
            isLogged = true;
            app.getNavigationHelper().openHomePage();
            app.getLoginHelper().login(Generator.parserUser());
        }
    }


}
