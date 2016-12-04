package com.company.domain;

import java.util.List;

/**
 * Created by semantier on 11/27/2016.
 */
public class School {
    private final List<SchoolClass> classes;

    public School(List<SchoolClass> classes) {
        this.classes = classes;
    }

    public List<SchoolClass> getClasses() {
        return classes;
    }
}
