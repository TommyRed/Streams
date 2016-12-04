package com.company.domain;

import java.util.Arrays;
import java.util.List;

import static com.company.domain.GradeType.*;
import static com.company.domain.Subject.*;

/**
 * Created by semantier on 11/27/2016.
 */
public class MockDataProvider {

    public static School getNewSchool(){

        SchoolClass c4 = new SchoolClass("C4", getC4Students());
        SchoolClass a1 = new SchoolClass("A1", getA1Students());

        return new School(Arrays.asList(c4, a1));
    }

    private static List<Student> getC4Students() {

        Student pepa = new Student(
                "Pepa",
                14,
                Gender.MALE,
                Arrays.asList(
                        new Grade(MATH, A),
                        new Grade(MATH, B),
                        new Grade(GEOLOGY, B),
                        new Grade(GEOLOGY, F),
                        new Grade(BIOLOGY, C)
                ),
                MATH);

        Student lucka = new Student(
                "Lucie",
                15,
                Gender.FEMALE,
                Arrays.asList(
                        new Grade(MATH, F),
                        new Grade(MATH, B),
                        new Grade(GEOLOGY, B),
                        new Grade(GEOLOGY, A),
                        new Grade(BIOLOGY, B),
                        new Grade(COMPUTER_SCIENCE, B),
                        new Grade(COMPUTER_SCIENCE, C)
                ),
                GEOLOGY);

        Student tomas = new Student(
                "Tomas",
                13,
                Gender.MALE,
                Arrays.asList(
                        new Grade(COMPUTER_SCIENCE, B),
                        new Grade(COMPUTER_SCIENCE, A),
                        new Grade(COMPUTER_SCIENCE, A)
                ),
                COMPUTER_SCIENCE);

        return Arrays.asList(pepa, lucka, tomas);
    }

    private static List<Student> getA1Students() {

        Student anna = new Student(
                "Anna",
                9,
                Gender.FEMALE,
                Arrays.asList(
                        new Grade(MATH, F),
                        new Grade(GEOLOGY, E),
                        new Grade(GEOLOGY, E)
                ),
                MATH);

        Student marketa = new Student(
                "Marketa",
                12,
                Gender.FEMALE,
                Arrays.asList(
                        new Grade(MATH, C),
                        new Grade(MATH, B),
                        new Grade(GEOLOGY, F),
                        new Grade(GEOLOGY, E),
                        new Grade(BIOLOGY, F),
                        new Grade(COMPUTER_SCIENCE, A),
                        new Grade(COMPUTER_SCIENCE, A)
                ),
                COMPUTER_SCIENCE);


        return Arrays.asList(anna, marketa);
    }
}
