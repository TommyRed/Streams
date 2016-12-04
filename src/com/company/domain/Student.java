package com.company.domain;

import java.util.List;

/**
 * Created by semantier on 11/27/2016.
 */
public class Student {
    private final String name;
    private final int age;
    private final Gender gender;
    private final List<Grade> grades;
    private final Subject favouriteSubject;

    public Student(String name, int age, Gender gender, List<Grade> grades, Subject favouriteSubject) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grades = grades;
        this.favouriteSubject = favouriteSubject;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public Subject getFavouriteSubject() {
        return favouriteSubject;
    }
}
