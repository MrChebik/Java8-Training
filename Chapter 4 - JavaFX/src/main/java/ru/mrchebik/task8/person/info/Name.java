package ru.mrchebik.task8.person.info;

/**
 * Created by mrchebik on 8/24/17.
 */
public class Name {
    private String firstname;
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "'" + firstname + " " + lastname + "'";
    }
}
