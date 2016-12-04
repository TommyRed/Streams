package com.company.domain;

/**
 * Created by semantier on 11/27/2016.
 */
public class Grade implements Comparable<Grade> {
    private final Subject subject;
    private final GradeType type;

    public Grade(Subject subject, GradeType type) {
        this.subject = subject;
        this.type = type;
    }

    public Subject getSubject() {
        return subject;
    }

    public GradeType getType() {
        return type;
    }

    @Override
    public int compareTo(Grade o) {
        if (type.getValue() > o.getType().getValue()) return 1;
        else if (type.getValue() < o.getType().getValue()) return -1;
        else return 0;
    }
}
