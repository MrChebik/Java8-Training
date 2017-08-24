package ru.mrchebik.task8.person;

import ru.mrchebik.task8.person.info.Address;
import ru.mrchebik.task8.person.info.Name;

/**
 * Created by mrchebik on 8/24/17.
 */
public class Person {
    private Name name;
    private Address address;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
