package models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CustomerModel {
    private String firstNameValue;
    private String lastNameValue;
    private String postCodeValue;
    private String currencyValue;
    private String fullname;

    //ar trebui sa incarc fisierul Json
    //ar trebui sa citesc din fisier si sa extrag valorile
    //valorile pe care le-am extras, trebuie sa le dau ca parametrii mai jos

    public CustomerModel (String filePath) {
        loadFromJson(filePath);
    }

    public void loadFromJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readerForUpdating(this)
                        .readValue(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getPostCodeValue() {
        return postCodeValue;
    }

    public void setPostCodeValue(String postCodeValue) {
        this.postCodeValue = postCodeValue;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setCurrencyValue(String currencyValue) {
        this.currencyValue = currencyValue;
    }
}
