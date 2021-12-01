package ru.itis.test.data;

public class MyAddress {
    private String firstName;
    private String lastName;
    private String city;
    private String zipCode;
    private String address1;
    private String houseNumber;
    private String apartmentNumber;
    private String phoneNumber;

    public MyAddress(String firstName, String lastName, String city, String zipCode, String address1, String houseNumber, String apartmentNumber, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.zipCode = zipCode;
        this.address1 = address1;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "MyAddress{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", address1='" + address1 + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public MyAddress() {
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
