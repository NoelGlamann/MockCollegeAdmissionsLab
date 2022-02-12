package edu.neumont;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class CollegeController{
    private CollegeInterface ci = new CollegeInterface();
    College college = new College("College");

    public void run() throws IOException{
        boolean keepLooping = true;
        while(keepLooping){
            ci.displayMainMenu(college.getName());
            int selection = ci.getUserInputAsInt(1,6);
            switch (selection) {
                case 1 -> renameCollege();
                case 2 -> viewTypeMenu();
                case 3 -> editFaculty();
                case 4 -> editStaff();
                case 5 -> editStudent();
                case 6 -> keepLooping = false;
                default -> throw new IllegalArgumentException("unknown menu item\n");
            }
        }
        System.out.println("Program Ended Successfully");
    }

    private void renameCollege() throws IOException {
        String newName = ci.reNamingCollege();
        college.setName(newName);
        System.out.println("College successfully renamed to " + newName);
        System.out.println();
    }

    private void viewTypeMenu() throws IOException {
        ci.displayViewTypesMenu();
        int selection = ci.getUserInputAsInt(1,4);
        switch (selection) {
            case 1 -> System.out.println(college.getFaculty() + "\n");
            case 2 -> System.out.println(college.getStaff() + "\n");
            case 3 -> System.out.println(college.getStudents() + "\n");
            case 4 -> System.out.println();
        }
    }


    private void editFaculty() throws IOException {
        ci.displayEditPersonMenu("faculty");
        int selection = ci.getUserInputAsInt(1,3);
        switch (selection) {
            case 1 -> {
                Faculty facultyToAdd = ci.addFaculty();
                college.addFaculty(facultyToAdd);
            }
            case 2 -> {
                String facultyToRemove = ci.findPersonToRemove("faculty");
                ArrayList<Faculty> facultyList = college.getFaculty();
                boolean wasFound = false;
                for (Faculty faculty : facultyList) {
                    if (faculty.getName().toLowerCase(Locale.ROOT).contains(facultyToRemove.toLowerCase(Locale.ROOT))) {
                        String confirmed = ci.verifyRemoval(faculty.getName());
                        if (confirmed=="yes"){
                            wasFound = true;
                            college.removeFaculty(faculty);
                            System.out.println(faculty.getName() + " has been removed from system.\n ");
                            break;
                        }
                    }
                }
                if (!wasFound){
                    System.out.println("Faculty member not found. Please Try Again. \n");
                }
            }
            case 3 -> System.out.println();
        }

    }
    private void editStaff() throws IOException {
        ci.displayEditPersonMenu("staff");
        int selection = ci.getUserInputAsInt(1,3);
        switch (selection) {
            case 1 -> {
                Staff staffToAdd = ci.addStaff();
                college.addStaff(staffToAdd);
            }
            case 2 -> {
                String staffToRemove = ci.findPersonToRemove("staff");
                ArrayList<Staff> staffList = college.getStaff();
                boolean wasFound = false;
                for (Staff staff : staffList) {
                    if (staff.getName().toLowerCase(Locale.ROOT).contains(staffToRemove.toLowerCase(Locale.ROOT))) {
                        String confirmed = ci.verifyRemoval(staff.getName());
                        if (confirmed=="yes"){
                            wasFound = true;
                            college.removeStaff(staff);
                            System.out.println(staff.getName() + " has been removed from system.\n ");
                            break;
                        }
                    }
                }
                if (!wasFound){
                    System.out.println("Staff member not found. Please Try Again. \n");
                }
            }
            case 3 -> System.out.println();
        }
    }
    private void editStudent() throws IOException {
        ci.displayEditPersonMenu("student");
        int selection = ci.getUserInputAsInt(1,3);
        switch (selection) {
            case 1 -> {
                Student studentToAdd = ci.addStudent();
                //TEST ADVOCATE SO PROGRAM RUNS
                Staff testAdvocate = new Staff("Jamie Bowman", 8, 4, 1982, "Student Advocate");
                college.addStaff(testAdvocate);
                college.setStudentAdvocate(studentToAdd, testAdvocate);
                college.addStudent(studentToAdd);
            }
            case 2 -> {
                String studentToRemove = ci.findPersonToRemove("student");
                ArrayList<Student> studentList = college.getStudents();
                boolean wasFound = false;
                for (Student student : studentList) {
                    if (student.getName().toLowerCase(Locale.ROOT).contains(studentToRemove.toLowerCase(Locale.ROOT))) {
                        String confirmed = ci.verifyRemoval(student.getName());
                        if (confirmed=="yes"){
                            wasFound = true;
                            college.removeStudent(student);
                            System.out.println(student.getName() + " has been removed from system.\n ");
                            break;
                        }
                    }
                }
                if (!wasFound){
                    System.out.println("Student not found. Please Try Again. \n");
                }
            }
            case 3 -> System.out.println();
        }
    }
}
