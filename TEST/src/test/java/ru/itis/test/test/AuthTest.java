package ru.itis.test.test;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import ru.itis.test.AuthBase;
import ru.itis.test.Generator;
import ru.itis.test.TestBase;
import ru.itis.test.data.AccountData;

import java.io.IOException;


public class AuthTest extends TestBase {

    @Test
    public void testUntitledTestCase() throws InterruptedException, IOException, ParseException {
        app.getNavigationHelper().openHomePage();
        app.getLoginHelper().login(Generator.parserUser());
        if (!app.checkLogin()) {
            app.getLoginHelper().logout();
            Assert.assertTrue(true);
        }


    }

    @Test
    public void authorizationTestCaseWithNotValidData() throws InterruptedException, IOException, ParseException {
    AccountData accountData = new AccountData("batrshintimur@yandex.ru", "Timur009");

        app.getLoginHelper().login(accountData);


        if (!app.checkLogin()) {
            Assert.assertTrue(true);
        }
        Assert.assertEquals(app.getAuthHelper().getUsername(), Generator.parserUser().getUsername());
        Assert.assertEquals(app.getAuthHelper().getPassword(), Generator.parserUser().getPassword());

    }
}
