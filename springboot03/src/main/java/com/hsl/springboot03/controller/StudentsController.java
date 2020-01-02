package com.hsl.springboot03.controller;

import com.hsl.springboot03.dao.StudentsDao;
import com.hsl.springboot03.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-02 16:45
 */
@RestController
public class StudentsController {
    @Autowired
    private StudentsDao studentsDao;

    /**
     * 删除
     * @param stu
     * @return
     */
    @RequestMapping("/del")
    public String del(Students stu){
        studentsDao.delete(stu);
        return "success";
    }

    /**
     * 添加
     * @param stu
     * @return
     */
    @RequestMapping("/add")
    public String add(Students stu){
        studentsDao.save(stu);
        return "success";
    }

    /**
     * 修改
     * @param stu
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Students stu){
        studentsDao.save(stu);
        return "success";
    }

    /**
     * 查询单个
     * @param sid
     * @return
     */
    @RequestMapping("/selectOne")
    public Students selectOne(Integer sid){

        return studentsDao.findById(sid).get();
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/selectAll")
    public List<Students> selectAll(){
        return studentsDao.findAll();
    }

}
