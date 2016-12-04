package com.company.domain;

import java.util.List;

/**
 * Created by semantier on 11/27/2016.
 */
public class SchoolClass {
    private final String name;
    private final List<Student> students;

    public SchoolClass(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }
}
