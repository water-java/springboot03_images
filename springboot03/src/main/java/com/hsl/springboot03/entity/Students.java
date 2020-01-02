package com.hsl.springboot03.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-02 16:26
 */
@Data
@Entity
@Table(name="t_spring_students_2020")
public class Students {
    @Id
    @GeneratedValue
    private Integer sid;
    @Column(length = 100)
    private String sname;
    @Column(length = 2)
    private String sex;
}
