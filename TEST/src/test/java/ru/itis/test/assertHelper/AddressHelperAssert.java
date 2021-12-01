package ru.itis.test.assertHelper;

import ru.itis.test.helpers.ApplicationManager;
import ru.itis.test.helpers.HelperBase;

public class AddressHelperAssert extends HelperBase {

    private String firstName;
    private String lastName;
    private String city;

    public AddressHelperAssert(ApplicationManager manager) {
        super(manager);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
