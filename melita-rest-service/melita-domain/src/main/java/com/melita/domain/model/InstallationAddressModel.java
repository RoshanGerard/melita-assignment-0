package com.melita.domain.model;

/**
 * Installation address model.
 *
 * @author Roshan Bolonna
 */
public class InstallationAddressModel {

    private String street;
    private String country;
    private String state;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
