package edu.neumont;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollegeInterface {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void displayMainMenu(String collegeName) {
        System.out.println(collegeName+ " Console Interface");
        System.out.println("-------------------------------");
        System.out.println("What would you like to do?\r\n" +
                "\t1 - Re-name College\r\n" +
                "\t2 - View Faculty, Staff, or Students\r\n" +
                "\t3 - Add/Remove Faculty \r\n" +
                "\t4 - Add/Remove Staff \r\n" +
                "\t5 - Add/Remove Student \r\n" +
                "\t6 - Exit\r\n");
    }

    public int getUserInputAsInt(int min, int max) throws IOException {
        float value = getUserInputAsFloat(min, max);
        //3.6
        return (int) value;
    }

    public float getUserInputAsFloat(float min, float max) throws IOException {
        float input = 0;
        do {
            String line = in.readLine();
            try {
                input = Float.parseFloat(line);
                if (input < min || input > max) {
                    throw new NumberFormatException("out of range");
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Input invalid. " +
                        "You must enter a number between " + min + " and " + max);
            }
        } while (true);
        return input;
    }

    public String reNamingCollege() throws IOException {
        System.out.println("What would you like to name this college? \n");
        return in.readLine();
    }

    public void displayViewTypesMenu() {
        System.out.println("Which would you like to view?\r\n" +
                "\t1 - Faculty\r\n" +
                "\t2 - Staff\r\n" +
                "\t3 - Students\r\n" +
                "\t4 - Back\r\n");
    }

    public void displayEditPersonMenu(String person) {
        System.out.println("Would you like to add or remove a " + person + "?\r\n" +
                "\t1 - Add\r\n" +
                "\t2 - Remove\r\n" +
                "\t3 - Exit\r\n");
    }

    public Faculty addFaculty() throws IOException {
        Faculty faculty = new Faculty();
        System.out.println("What is their full name as you would like it in the system?");
        faculty.setName(in.readLine());
        System.out.println("Birth Month: ");
        int month = Integer.parseInt(in.readLine());
        System.out.println("Birth Date: ");
        int date = Integer.parseInt(in.readLine());
        System.out.println("Birth Year: ");
        int year = Integer.parseInt(in.readLine());
        faculty.setBirthdate(month, date, year);
        System.out.println("Current Office Number: ");
        int officeNum = Integer.parseInt(in.readLine());
        faculty.setOfficeNumber(officeNum);
        System.out.println("Establish office hours: ");
        String oHours = in.readLine();
        faculty.setOfficeHours(oHours);
        System.out.println("Position Status? (FullTime or Adjunct)");
        String pStatus = in.readLine();
        faculty.setPositionStatus(pStatus);
        System.out.println();
        System.out.println("Faculty member added successfully.");
        System.out.println();
        return faculty;
    }
    public Staff addStaff() throws IOException {
        Staff staff = new Staff();
        System.out.println("What is their full name as you would like it in the system?");
        staff.setName(in.readLine());
        System.out.println("Birth Month: ");
        int month = Integer.parseInt(in.readLine());
        System.out.println("Birth Date: ");
        int date = Integer.parseInt(in.readLine());
        System.out.println("Birth Year: ");
        int year = Integer.parseInt(in.readLine());
        staff.setBirthdate(month, date, year);
        System.out.println("What is their official job title?");
        String jobTitle = in.readLine();
        staff.setJobTitle(jobTitle);
        System.out.println();
        System.out.println("Staff member added successfully.");
        System.out.println();
        return staff;
    }
    public Student addStudent() throws IOException {
        Student student = new Student();
        System.out.println("What is their full name as you would like it in the system?");
        student.setName(in.readLine());
        System.out.print("Birth Month: ");
        int month = Integer.parseInt(in.readLine());
        System.out.print("Birth Date: ");
        int date = Integer.parseInt(in.readLine());
        System.out.print("Birth Year: ");
        int year = Integer.parseInt(in.readLine());
        student.setBirthdate(month, date, year);
        System.out.print("Current GPA: ");
        double currentGpa = Double.parseDouble(in.readLine());
        student.setGpa(currentGpa);
        System.out.println();
        System.out.println("Student added successfully.");
        System.out.println();
        return student;
    }

    public String findPersonToRemove(String person) throws IOException {
        System.out.println("What is the name of the " + person + " member you wish to remove?\n");
        String personToRemove = in.readLine();
        return personToRemove;
    }

    public String verifyRemoval(String name) throws IOException {
        System.out.println("Do you wish to remove " + name + "? (Y/n)\n");
        String response = in.readLine();
        String returnValue;
        if (response.equals("no") || response.equals("n") || response.equals("No") || response.equals("NO")) {
            returnValue = "no";
        } else {
            returnValue = "yes";
        }
        return returnValue;
    }
}