package org.example.grade;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;


    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public double calculateGrade() {
        double multipliedCreditAndCourseGrade =courses.multipliedCreditAndCourseGrade();

        int totalCompletedCredit = courses.calculateTotalCompletedCredit();
        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
