package com.myproject.constant;

import lombok.Getter;

@Getter
public enum AssignmentEnum {
    ASSIGNMENT_1(1, "HTML Assignment"),
    ASSIGNMENT_2(2, "Guessing Game"),
    ASSIGNMENT_3(3, "User login"),
    ASSIGNMENT_4(4, "Student course list"),
    ASSIGNMENT_5(5, "Custom array list"),
    ASSIGNMENT_6(6, "Reports with Streams"),
    ASSIGNMENT_7(7, "Unit test"),
    ASSIGNMENT_8(8, "Multi threading"),
    ASSIGNMENT_9(9, "Spring MVC"),
    ASSIGNMENT_10(10, "REST ful Service"),
    ASSIGNMENT_11(11, "Full stack with thymeleaf"),
    ASSIGNMENT_12(12, "Report with SQL"),
    ASSIGNMENT_13(13, "Online bank"),
    ASSIGNMENT_14(14, "CHatting with JS");

    private int assignmentNum;
    private String assignmentName;

    AssignmentEnum (int assignmentNum, String assignmentName){
        this.assignmentNum = assignmentNum;
        this.assignmentName = assignmentName;
    }
}
