package edu.neumont;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class Student extends College{
    /*
    A Student has a name, birth-date, GPA,
    a staff advocate/adviser, and a list of
    courses in which the student is enrolled.
     */
    private String name;
    private int[] birthdate = new int[3];
    private double gpa;
    private Staff advocate;
    private ArrayList<String> courses = new ArrayList<>();
    public static final int MIN_NAME_LENGTH = 3;

    Student(){}
    Student(String _name, double gpa, int birthMonth, int birthdate, int birthYear){
        setName(_name);
        setGpa(gpa);
        setBirthdate(birthMonth, birthdate, birthYear);
    }

    public void setName(String name) {
        if(name == null || name.length() < MIN_NAME_LENGTH){
            System.out.println("Invalid. Name may not me empty or shorter than 3 characters.");
        } else{
            this.name = name;
        }
    }
    public void setGpa(double gpa) {
        if (gpa<0.0 || gpa>5.0){
            System.out.println("Invalid GPA.");
        } else{
            this.gpa = gpa;
        }
    }
    public void setBirthdate(int month, int date, int year) {
        Year thisYear = Year.now();
        if(month<0 || month>12){
            System.out.println("Invalid. Birthdate will not be set.");
        }
        else if ((month==1 || month ==3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 11) && date>31){
            System.out.println("Invalid. Birthdate will not be set.");
        }
        else if((month==4 || month ==6 || month == 9 || month == 11) && date>30){
            System.out.println("Invalid. Birthdate will not be set.");
        }
        else if (month == 2 && date > 29){
            System.out.println("Invalid. Birthdate will not be set.");
        }
        else if (year>thisYear.getValue()){
            System.out.println("Invalid. Birthdate will not be set.");
        }else{
            this.birthdate[0] = month;
            this.birthdate[1] = date;
            this.birthdate[2] = year;
        }
    }
    public void setAdvocate(Staff advocate) {
        this.advocate = advocate;
    }
    public void addCourse(Course _course) {
        this.courses.add(_course.getTitle());
    }
    public void removeCourse(Course _course){
        this.courses.remove(_course.getTitle());
    }

    public String getName() {
        return name;
    }
    public int[] getBirthdate() {
        return birthdate;
    }
    public double getGpa() {
        return gpa;
    }
    public Staff getAdvocate() {
        return advocate;
    }
    public ArrayList<String> getCourseList() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{\n" +
                "\tname='" + name + "'\n" +
                "\tbirthdate=" + Arrays.toString(birthdate) + "\n" +
                "\tgpa=" + gpa+ "\n" +
                "\tadvocate=" + advocate.getName() + "\n" +
                "\tcourses=" + courses + "\n" +
                '}';
    }
}
