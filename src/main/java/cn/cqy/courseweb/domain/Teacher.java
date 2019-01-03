package cn.cqy.courseweb.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Teacher {
    @Id
    @Column(name="teacher_id",nullable = false)
    private String teacherID;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="title",nullable = false)
    private String title;
    @Column(name="college",nullable = false)
    private String college;
    @Column(name="email",nullable = true)
    private String email;
    @Column(name="phone",nullable = true)
    private String phone;
    @Column(name="address",nullable = true)
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
