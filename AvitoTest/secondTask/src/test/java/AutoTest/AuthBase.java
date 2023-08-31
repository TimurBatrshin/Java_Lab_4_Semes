package AutoTest;

import org.junit.Before;
import AutoTest.helpers.ApplicationManager;

public class AuthBase {

    public ApplicationManager app;

    @Before
    public void setUp() {
        app = ApplicationManager.getInstance();
    }
}
