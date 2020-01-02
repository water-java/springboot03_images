package com.hsl.springboot03.teacher.entiry;

import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "t_springboot_teacher")
@ToString
public class Teacher {
    @Id
    @GeneratedValue
    private Integer tid;
    @Column(length = 16)
    private String tname;
    @Column(length = 4)
    private String sex;
    @Column(length = 100)
    private String description;
    @Column(length = 200)
    private String imagePath;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
