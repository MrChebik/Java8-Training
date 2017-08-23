package ru.mrchebik.task3.person;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by mrchebik on 8/23/17.
 */
public class Person {
    public static final String FIRST_NAME_DEFAULT = "John";
    public static final String LAST_NAME_DEFAULT = "Black";

    private String firstNameValue = FIRST_NAME_DEFAULT;
    private String lastNameValue = LAST_NAME_DEFAULT;

    public StringProperty firstName;
    public StringProperty lastName;

    public Person() {
    }

    public Person(String firstNameValue, String lastNameValue) {
        if (!firstNameValue.equalsIgnoreCase(FIRST_NAME_DEFAULT)) {
            this.firstName = new SimpleStringProperty(firstNameValue);
        } else {
            this.firstNameValue = firstNameValue;
        }
        if (!lastNameValue.equalsIgnoreCase(LAST_NAME_DEFAULT)) {
            this.lastName = new SimpleStringProperty(lastNameValue);
        } else {
            this.lastNameValue = lastNameValue;
        }
    }

    public final StringProperty firstNameProperty() {
        if (firstName == null) {
            firstName = new SimpleStringProperty(firstNameValue);
        }
        return firstName;
    }

    public final void setFirstName(String newValue) {
        if (firstName != null) {
            firstName.setValue(newValue);
        } else {
            if (!newValue.equalsIgnoreCase(FIRST_NAME_DEFAULT)) {
                this.firstName = new SimpleStringProperty(newValue);
            } else {
                this.firstNameValue = newValue;
            }
        }
    }

    public final String getFirstName() {
        return firstName != null ? firstName.getValue() : firstNameValue;
    }

    public final StringProperty lastNameProperty() {
        if (lastName == null) {
            lastName = new SimpleStringProperty(lastNameValue);
        }
        return lastName;
    }

    public final void setLastName(String newValue) {
        if (lastName != null) {
            lastName.setValue(newValue);
        } else {
            if (!newValue.equalsIgnoreCase(LAST_NAME_DEFAULT)) {
                this.lastName = new SimpleStringProperty(newValue);
            } else {
                this.lastNameValue = newValue;
            }
        }
    }

    public final String getLastName() {
        return lastName != null ? lastName.getValue() : lastNameValue;
    }
}
