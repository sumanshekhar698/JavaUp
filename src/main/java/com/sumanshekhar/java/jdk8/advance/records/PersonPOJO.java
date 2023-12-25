package com.sumanshekhar.java.jdk8.advance.records;

import java.time.LocalDate;
import java.util.Objects;

public final class PersonPOJO {
    //    If you are already familiar with the Java release cadence and the latest LTS version,
    //    Java 17, you can explore the Java Record feature that allows immutable classes.
    private final String name;

    private final LocalDate birthday;

    private final String city;

    public PersonPOJO(String name, LocalDate birthday, String city) {
        this.name = name;
        this.birthday = birthday;
        this.city = city;
    }


    public String name() {
        return name;
    }

    public LocalDate birthday() {
        return birthday;
    }

    public String city() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonPOJO person = (PersonPOJO) o;
        return Objects.equals(name, person.name)
                && Objects.equals(birthday, person.birthday)
                && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, city);
    }

    @Override
    public String toString() {
        return "OldPerson{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
                '}';
    }
}