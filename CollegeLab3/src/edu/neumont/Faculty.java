package edu.neumont;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class Faculty extends College{
    /*
     * A Faculty member has a name, birth-date,
     * office number, office hours, and a collection
     * of courses which they currently teach.
     * A faculty member may be either full-time or adjunct.
     */
    private String name;
    private int[] birthdate = new int[3];
    private int officeNumber;
    private String officeHours;
    private String positionStatus;
    private ArrayList<String> coursesTeaching = new ArrayList<>();
    public static final int MIN_NAME_LENGTH = 3;

    Faculty(){}
    Faculty(String name, int birthMonth, int birthDate, int birthYear, int officeNumber, String officeHours, String positionStatus){
        setName(name);
        setBirthdate(birthMonth, birthDate, birthYear);
        setOfficeNumber(officeNumber);
        setOfficeHours(officeHours);
        setPositionStatus(positionStatus);
    }

    public void setName(String name) {
        if(name == null || name.length() < MIN_NAME_LENGTH){
            System.out.println("Invalid. Name may not me empty or shorter than 3 characters.");
        } else{
            this.name = name;
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
    /*
     * Faculty members may have their office number or office hours changed.
     */
    public void setOfficeNumber(int officeNumber) {
        if (officeNumber<0 || officeNumber>400){
            System.out.println("Room does not exist. Office number will not be set. ");
        }
        this.officeNumber = officeNumber;
    }
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
    public void setPositionStatus(String positionStatus) {
        this.positionStatus = positionStatus;
    }
    public void addCourseTeaching(Course _course) {
        this.coursesTeaching.add(_course.getTitle());
    }
    public void removeCourseTeaching(Course _course){
        this.coursesTeaching.remove(_course.getTitle());
    }

    public String getName() {
        return name;
    }
    public int[] getBirthdate() {
        return birthdate;
    }
    public int getOfficeNumber() {
        return officeNumber;
    }
    public String getOfficeHours() {
        return officeHours;
    }
    public String getPositionStatus() {
        return positionStatus;
    }
    public ArrayList<String> getCoursesTeaching() {
        return coursesTeaching;
    }

    @Override
    public String toString() {
        return "Faculty{\n" +
                "\tname='" + name + "'\n" +
                "\tbirthdate=" + Arrays.toString(birthdate) + '\n'+
                "\tofficeNumber=" + officeNumber + '\n'+
                "\tofficeHours='" + officeHours + '\n'+
                "\tpositionStatus='" + positionStatus + '\n'+
                "\tcoursesTeaching=" + coursesTeaching + '\n'+
                '}';
    }
}
