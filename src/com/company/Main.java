package com.company;


import com.company.domain.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args) {
    }

    // refactoring java 7 => 8

    public static void printNameAndAgeOfEveryStudent(List<Student> students) {
        students.forEach(s -> System.out.println(s.getName() + " : " + s.getAge()));
    }

    // map - method reference
    public static List<Integer> getStudentAges(List<Student> students) {
        return students.stream()
                       .map(Student::getAge)
                       .collect(Collectors.toList());
    }

    // map
    public static List<Student> getMultiplyStudentAge(List<Student> students) {
        return students.stream()
                       .map(s -> new Student(s.getName(), s.getAge() * 2, s.getGender(), s.getGrades(), s.getFavouriteSubject()))
                       .collect(Collectors.toList());
    }

    // filter
    public static List<Student> getStudentsWithMinimumAge(List<Student> students, int minAge) {
        return students.stream()
                       .filter(student -> student.getAge() == minAge)
                       .collect(Collectors.toList());
    }

    // filter and possible double method references
    public static List<Integer> getPrimeAges(List<Student> students) {
        return getStudentAges(students).stream()
                                       .filter(Main::isPrime)
                                       .collect(Collectors.toList());

    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    // comparing (sorted)
    public static List<Integer> getSortedAges(List<Student> students) {
        return getStudentAges(students).stream()
                                       .sorted(Integer::compareTo)
                                       .collect(Collectors.toList());
    }

    // count
    public static long countMaleStudents(List<Student> students) {
        return students.stream()
                       .filter(student -> student.getGender()
                                                 .equals(Gender.MALE))
                       .count();
    }


    // average, orElse
    public static double avgAgeOfFemaleStudent(List<Student> students) {
        return students.stream()
                       .filter(student -> student.getGender()
                                                 .equals(Gender.FEMALE))
                       .mapToInt(Student::getAge)
                       .average()
                       .getAsDouble();
    }


    // reduce
    public static double productOfStudentGrades(Student student) {
        return student.getGrades()
                      .stream()
                      .mapToDouble(grade -> grade.getType()
                                                 .getValue())
                      .reduce((a, b) -> a + b)
                      .getAsDouble();
    }


    // sorted(default), findFirst
    public static Optional<Grade> getBestMathGradeFromStudent(Student student) {
        return student.getGrades()
                      .stream()
                      .filter(grade -> grade.getSubject()
                                            .equals(Subject.MATH))
                      .sorted(Comparator.reverseOrder())
                      .findFirst();
    }

    // anyMatch
    public static boolean atLeastOneGradeA(Student student) {
        return student.getGrades()
                      .stream()
                      .anyMatch(s -> s.getType()
                                      .equals(GradeType.A));
    }


    // limit, IntStream.iterate, boxed
    public static List<Integer> getFirstPrimes(final int howMany) {
        return IntStream.iterate(2, i -> i + 1)
                        .filter(Main::isPrime)
                        .limit(howMany)
                        .boxed()
                        .collect(Collectors.toList());
    }
}
