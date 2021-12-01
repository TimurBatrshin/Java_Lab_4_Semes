package ru.itis.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.itis.test.TestBase;
import ru.itis.test.data.AccountData;
import ru.itis.test.data.MyAddress;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Generator {

    public static void main(String[] args) throws IOException, ParseException {
        generator();
        System.out.println(parser());
        System.out.println(parserUser());
        System.out.println(parserMyAddress());
    }

    public static void generator() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        String password = scanner.nextLine();
        AccountData accountData = new AccountData(email, password);
        ObjectMapper objectMapper = new ObjectMapper();
        MyAddress myAddress = new MyAddress(TestBase.generateRandomString(), TestBase.generateRandomString(), "Kazan", "453480", "Pushkina", "32", "401", "937)333-51-98");
        MyAddress myAddress1 = new MyAddress(TestBase.generateRandomString(), TestBase.generateRandomString(), "Kazan", "453481", "Pushkina", "32", "401", "937)333-51-98");
        objectMapper.writeValue(new File("target/myAddress.json"), myAddress);
        objectMapper.writeValue(new File("target/myAddress1.json"), myAddress1);
        objectMapper.writeValue(new File("target/accountData.json"), accountData);

    }

    public static MyAddress parser() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object myAddressObj = parser.parse(new FileReader("target/myAddress.json"));
        JSONObject jsonObject = (JSONObject) myAddressObj;
        MyAddress myAddress = new MyAddress();
        myAddress.setFirstName((String) jsonObject.get("firstName"));
        myAddress.setLastName((String) jsonObject.get("lastName"));
        myAddress.setCity((String) jsonObject.get("city"));
        myAddress.setAddress1((String) jsonObject.get("address1"));
        myAddress.setApartmentNumber((String) jsonObject.get("apartmentNumber"));
        myAddress.setPhoneNumber((String) jsonObject.get("phoneNumber"));
        myAddress.setHouseNumber((String) jsonObject.get("houseNumber"));
        myAddress.setZipCode((String) jsonObject.get("zipCode"));

        return myAddress;
    }

    public static AccountData parserUser() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object userObj = parser.parse(new FileReader("target/accountData.json"));
        JSONObject jsonObject = (JSONObject) userObj;
        return new AccountData((String) jsonObject.get("username"), (String) jsonObject.get("password"));
    }

    public static MyAddress parserMyAddress() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object myAddressObj = parser.parse(new FileReader("target/myAddress1.json"));
        JSONObject jsonObject = (JSONObject) myAddressObj;
        MyAddress myAddress = new MyAddress();
        myAddress.setFirstName((String) jsonObject.get("firstName"));
        myAddress.setLastName((String) jsonObject.get("lastName"));
        myAddress.setCity((String) jsonObject.get("city"));
        myAddress.setAddress1((String) jsonObject.get("address1"));
        myAddress.setApartmentNumber((String) jsonObject.get("apartmentNumber"));
        myAddress.setPhoneNumber((String) jsonObject.get("phoneNumber"));
        myAddress.setHouseNumber((String) jsonObject.get("houseNumber"));
        myAddress.setZipCode((String) jsonObject.get("zipCode"));

        return myAddress;
    }


}
