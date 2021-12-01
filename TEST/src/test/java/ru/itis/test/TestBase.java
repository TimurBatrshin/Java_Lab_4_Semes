package ru.itis.test;

import org.junit.Before;
import ru.itis.test.data.AccountData;
import ru.itis.test.data.MyAddress;
import ru.itis.test.helpers.ApplicationManager;


public class TestBase {


    public ApplicationManager app;


    public static String generateRandomString() {
        int random = (int) (Math.random() * 5);
        String[] FI = new String[]{"Тимур", "Леха", "Алсу", "Робин", "Мальчик по имени Альберт", "Малкина"};

        return FI[random];
    }

    @Before
    public void setUp() throws Exception {
        app = ApplicationManager.getInstance();
    }


}
