package ru.mrchebik.task8.person.info;

/**
 * Created by mrchebik on 8/24/17.
 */
public class Address {
    private String street;
    private String city;
    private String county;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "'" + street + " " + city + " " + county + "'";
    }
}
