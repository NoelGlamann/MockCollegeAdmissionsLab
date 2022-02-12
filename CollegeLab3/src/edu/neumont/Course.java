package edu.neumont;

import java.util.ArrayList;

public class Course extends College {
    private String title;
    private Faculty teacher;
    private ArrayList<Student> participants = new ArrayList<>();

    Course(){}
    Course(String title, Faculty teacher){
        setTitle(title);
        setTeacher(teacher);
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setTeacher(Faculty teacher) {
        this.teacher = teacher;
    }
    public void changeTeacher(Faculty teacher){
        this.teacher = teacher;
    }
    public void addParticipants(Student _student) {
        this.participants.add(_student);
    }
    public void removeParticipants(Student _student){
        this.participants.remove(_student);
    }

    public String getTitle() {
        return title;
    }
    public Faculty getTeacher() {
        return teacher;
    }
    public ArrayList<String> getParticipants(ArrayList<Student> participants) {
        ArrayList<String> names = new ArrayList<>();
        for (Student participant: participants){
            names.add(participant.getName());
        }
        return names;
    }

    @Override
    public String toString() {
        return "Course{\n" +
                "\ttitle='" + title + "'\n" +
                "\tteacher=" + teacher.getName() + "\n"+
                "\tparticipants=" + getParticipants(participants) + "\n"+
                '}';
    }
}
