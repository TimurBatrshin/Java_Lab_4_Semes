package ru.itis.test.test;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.test.AuthBase;
import ru.itis.test.Generator;
import ru.itis.test.TestBase;

public class NewAddressTest extends AuthBase {


    @Test
    public void test() throws Exception {
        Thread.sleep(5000);
        app.getAddAddress().addMyAddress(Generator.parser());


        Assert.assertEquals(app.getAddressHelperAssert().getFirstName(), Generator.parser().getFirstName());
        Assert.assertEquals(app.getAddressHelperAssert().getLastName(), Generator.parser().getLastName());
        Assert.assertEquals(app.getAddressHelperAssert().getCity(), Generator.parser().getCity());
    }


}
