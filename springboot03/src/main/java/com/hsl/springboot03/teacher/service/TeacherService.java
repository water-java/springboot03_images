package com.hsl.springboot03.teacher.service;

import com.hsl.springboot03.teacher.entiry.Teacher;
import com.hsl.springboot03.uitls.PageBean;
import org.springframework.data.domain.Page;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-02 20:05
 */
public interface TeacherService {

    public Teacher save(Teacher teacher);

    public void deleteById(Integer id);

    public Teacher findById(Integer id);

    public Page<Teacher> listPager(Teacher teacher, PageBean pageBean);



}
