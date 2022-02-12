package edu.neumont;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class Staff extends College{
    /*
     * A Staff member has a name, birth-date, and a job title.
     */
    private String name;
    private int[] birthdate = new int[3];
    private String jobTitle;
    private ArrayList<String> advisingStudents = new ArrayList<>();
    public static final int MIN_NAME_LENGTH = 3;

    Staff(){}
    Staff(String name, int birthMonth, int birthDate, int birthYear, String jobTitle){
        setName(name);
        setBirthdate(birthMonth, birthDate, birthYear);
        setJobTitle(jobTitle);
    }

    public void setName(String name) {
        if(name == null || name.length() < MIN_NAME_LENGTH){
            System.out.println("Invalid. Name may not me empty or shorter than 3 characters.");
        } else{
            this.name = name;
        }
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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
    public void addAdvisingStudent(Student _student) {
        this.advisingStudents.add(_student.getName());
    }
    public void removeAdvisingStudent(Student _student){
        this.advisingStudents.remove(_student.getName());
    }

    public String getName() {
        return name;
    }
    public int[] getBirthdate() {
        return birthdate;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public ArrayList<String> getAdvisingStudents() {
        return advisingStudents;
    }


    @Override
    public String toString() {
        return "Staff{\n" +
                "\tname='" + name + "'\n" +
                "\tbirthdate=" + Arrays.toString(birthdate) + "\n" +
                "\tjobTitle='" + jobTitle + "\n" +
                "\tstudents=" + advisingStudents + "\n" +
                '}';
    }
}
