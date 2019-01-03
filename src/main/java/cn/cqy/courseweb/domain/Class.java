package cn.cqy.courseweb.domain;

import javax.persistence.*;
import java.util.ArrayList;

public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name="semester",nullable = false)
    private String semester;
    @Column(name="lesson_day",nullable = false)
    private String lessonDay;
    @Column(name="lesson_time",nullable = false)
    private String lessonTime;
    @Column(name="classroom",nullable = false)
    private String classroom;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Course course;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ArrayList<Teacher> teachers;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ArrayList<Student> students;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ArrayList<Resource> resources;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getLessonDay() {
        return lessonDay;
    }

    public void setLessonDay(String lessonDay) {
        this.lessonDay = lessonDay;
    }

    public String getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(String lessonTime) {
        this.lessonTime = lessonTime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }
}
