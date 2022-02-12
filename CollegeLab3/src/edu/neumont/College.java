package edu.neumont;

import java.util.ArrayList;

public class College {
    /*
     * Code accessing the college class
     * should be able to access all of
     * the information relationships
     * detailed above.
     */
    private String name;
    private ArrayList<Faculty> faculty = new ArrayList<>();
    private ArrayList<Staff> staff = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();

    College(){}
    College(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /*A College has collections of Faculty members,
      Staff members, and Students.  All of which
      may be added to, or removed from, the college.*/

    public void addFaculty(Faculty _faculty) {
        faculty.add(_faculty);
    }
    public void removeFaculty(Faculty _faculty){faculty.remove(_faculty);}
    public void addStaff(Staff _staff) {
        staff.add(_staff);
    }
    public void removeStaff(Staff _staff){staff.remove(_staff);}
    public void addStudent(Student _student) {
        students.add(_student);
    }
    public void removeStudent(Student _student) {students.remove(_student);}
    public void addCourse(Course _course) {
        courses.add(_course);
    }

    /*
     Students can be added to, or removed from, a course.
     */

    public void addStudentToCourse(Student _student, Course _course){
        _student.addCourse(_course);
        _course.addParticipants(_student);
    }
    public void removeStudentFromCourse(Student _student, Course _course){
        _student.removeCourse(_course);
        _course.removeParticipants(_student);
    }

    /*
     * Staff members may be assigned to advise one or more students (or no student at all).
     */
    public void setStudentAdvocate(Student _student, Staff _staff) {
        _staff.addAdvisingStudent(_student);
        _student.setAdvocate(_staff);
    }

    /*
     * Faculty members may be assigned to, or removed from, a course,
     */
    public void setCourseTeacher(Course _course, Faculty _teacher){
        _course.setTeacher(_teacher);
        _teacher.addCourseTeaching(_course);
    }
    public void changeCourseTeacher(Course _course, Faculty _teacher, Faculty _newTeacher){
        _course.changeTeacher(_newTeacher);
        _teacher.removeCourseTeaching(_course);
    }

    public ArrayList<Faculty> getFaculty() {
        return faculty;
    }
    public ArrayList<String> getFacultyNames(ArrayList<Faculty> list){
        ArrayList<String> names = new ArrayList<>();
        for(Faculty faculty: list){
            names.add(faculty.getName());
        }
        return names;
    }
    public ArrayList<Staff> getStaff() {
        return staff;
    }
    public ArrayList<String> getStaffNames(ArrayList<Staff> list){
        ArrayList<String> names = new ArrayList<>();
        for(Staff staff: list){
            names.add(staff.getName());
        }
        return names;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<String> getStudentNames(ArrayList<Student> list){
        ArrayList<String> names = new ArrayList<>();
        for(Student student: list){
            names.add(student.getName());
        }
        return names;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public ArrayList<String> getCourseTitles(ArrayList<Course> list){
        ArrayList<String> titles = new ArrayList<>();
        for(Course course: list){
            titles.add(course.getTitle());
        }
        return titles;
    }

    @Override
    public String toString() {
        return "College{\r\n" +
                "\tCollege Name='" + name + '\n' +
                "\t\tfaculty=" + getFacultyNames(faculty) + '\n'+
                "\t\tstaff=" + getStaffNames(staff) + '\n'+
                "\t\tstudents=" + getStudentNames(students) + '\n'+
                "\t\tcourses=" + getCourseTitles(courses) + '\n'+
                '}';
    }
}
