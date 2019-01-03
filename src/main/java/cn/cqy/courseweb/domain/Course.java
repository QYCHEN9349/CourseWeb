package cn.cqy.courseweb.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Course {
    @Id
    @Column(name = "course_id", nullable = false)
    private String courseId;
    @Column(name="description",nullable = true,length = 1024)
    private String description;
    @Column(name="college",nullable = false)
    private String college;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
