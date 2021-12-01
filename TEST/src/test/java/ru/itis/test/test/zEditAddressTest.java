package ru.itis.test.test;

import org.junit.Test;
import ru.itis.test.AuthBase;
import ru.itis.test.Generator;

public class zEditAddressTest extends AuthBase {

    @Test
    public void test2() throws Exception {
        app.getNavigationHelper().openBookPage();
        app.getEditAddressHelper().editAddress(Generator.parserMyAddress());


    }

}
