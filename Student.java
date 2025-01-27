package com.example;

public class Student {
    private String studentid;
    private String name;
    private int age;
    private String gender;
    private int roomNumber;
    private String contact;
    private int year;

    // Constructor
    public Student(String studentid, String name, int age, String gender, int roomNumber, String contact, int year) {
        this.studentid = studentid;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.roomNumber = roomNumber;
        this.contact = contact;
        this.year = year;
    }

    // Getter methods
    public String getStudentId() { return studentid; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public int getRoomNumber() { return roomNumber; }
    public String getContact() { return contact; }
    public int getYear() { return year; }
}
