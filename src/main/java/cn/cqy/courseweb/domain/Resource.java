package cn.cqy.courseweb.domain;

import javax.persistence.*;

public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="url",nullable = false)
    private String url;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Teacher uploader;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUploader(Teacher uploader) {
        this.uploader = uploader;
    }

    public Teacher getUploader() {
        return uploader;
    }
}
