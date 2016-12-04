package com.company;

import com.company.domain.Grade;
import com.company.domain.MockDataProvider;
import com.company.domain.School;
import com.company.domain.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by semantier on 11/28/2016.
 */
public class MainTest {

    private School school;
    private List<Student> students;

    @org.junit.Before
    public void setUp() throws Exception {
        school = MockDataProvider.getNewSchool();
        students = school.getClasses()
                         .stream()
                         .flatMap(classes -> classes.getStudents()
                                                    .stream())
                         .collect(Collectors.toList());
    }

    @org.junit.Test
    public void printNameAndAgeOfEveryStudent() throws Exception {
        // cannot test side-effects
        assertTrue(true);
    }

    @org.junit.Test
    public void getStudentAges() throws Exception {
        List<Integer> expected = Arrays.asList(14, 15, 13, 9, 12);
        List<Integer> actual = Main.getStudentAges(students);

        assertTrue(actual.equals(expected));
    }

    @org.junit.Test
    public void getMultiplyStudentAge() throws Exception {
        List<Integer> expected = Arrays.asList(28, 30, 26, 18, 24);
        List<Student> actual = Main.getMultiplyStudentAge(students);

        List<Integer> actualAges = actual.stream()
                                         .map(Student::getAge)
                                         .collect(Collectors.toList());

        assertTrue(actualAges.equals(expected));
    }

    @org.junit.Test
    public void getStudentsWithMinimumAge() throws Exception {
        Student student = school.getClasses()
                                .get(1)
                                .getStudents()
                                .get(0);
        List<Student> actual = Main.getStudentsWithMinimumAge(students, 9);

        assertTrue(actual.get(0)
                         .equals(student));
    }

    @org.junit.Test
    public void getPrimeAges() throws Exception {
        List<Integer> expected = Collections.singletonList(13);
        List<Integer> actual = Main.getPrimeAges(students);

        assertTrue(actual.equals(expected));
    }

    @org.junit.Test
    public void getSortedAges() throws Exception {
        List<Integer> expected = Arrays.asList(9, 12, 13, 14, 15);
        List<Integer> actual = Main.getSortedAges(students);

        assertTrue(actual.equals(expected));
    }

    @org.junit.Test
    public void countMaleStudents() throws Exception {
        long actual = Main.countMaleStudents(students);
        long expected = 2;

        assertTrue(actual == expected);
    }

    @org.junit.Test
    public void avgAgeOfFemaleStudent() throws Exception {
        double actual = Main.avgAgeOfFemaleStudent(students);
        double expected = 12;

        assertTrue(actual == expected);
    }

    @org.junit.Test
    public void productOfStudentGrades() throws Exception {
        double actual = Main.productOfStudentGrades(students.get(0));
        double expected = 320;

        assertTrue(actual == expected);
    }

    @org.junit.Test
    public void getBestMathGradeFromStudent() throws Exception {
        Optional<Grade> expected = Optional.of(students.get(0).getGrades().get(0));
        Optional<Grade> actual = Main.getBestMathGradeFromStudent(students.get(0));

        assertTrue(actual.get().compareTo(expected.get()) == 0);
    }

    @org.junit.Test
    public void atLeastOneGradeA() throws Exception {
        //test 1
        boolean actual = Main.atLeastOneGradeA(students.get(0));
        assertTrue(actual);

        //test 2
        boolean actual1 = Main.atLeastOneGradeA(students.get(3));
        assertFalse(actual1);
    }

    @org.junit.Test
    public void getFirstPrimes() throws Exception {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11);
        List<Integer> actual = Main.getFirstPrimes(5);

        assertTrue(actual.equals(expected));
    }

}