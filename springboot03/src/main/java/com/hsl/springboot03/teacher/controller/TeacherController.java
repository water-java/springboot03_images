package com.hsl.springboot03.teacher.controller;

import com.hsl.springboot03.teacher.entiry.Teacher;
import com.hsl.springboot03.teacher.service.TeacherService;
import com.hsl.springboot03.uitls.PageBean;
import com.hsl.springboot03.uitls.PageUtil;
import com.hsl.springboot03.uitls.StringUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-02 20:41
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 查看所有
     * @param teacher
     * @param request
     * @return
     */
    @RequestMapping("/listPager")
    public ModelAndView list(Teacher teacher, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        Page<Teacher> teachers = teacherService.listPager(teacher, pageBean);
        modelAndView.addObject("teachers", teachers.getContent());
        pageBean.setTotal(teachers.getTotalElements() + "");
        modelAndView.addObject("pageCode", PageUtil.createPageCode(pageBean));
        modelAndView.setViewName("list");
        return modelAndView;
    }

    /**
     * 修改
     * @param teacher
     * @return
     */
    @RequestMapping("/toEdit")
    public ModelAndView toEdit(Teacher teacher){
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.setViewName("edit");
    modelAndView.addObject("sexArr",new String[]{"男","女"});
    if(!(teacher.getTid()==null||"".equals(teacher.getTid()))){
        Teacher t=teacherService.findById(teacher.getTid());
        modelAndView.addObject("teacher",t);
    }
    return modelAndView;
    }

    /**
     * 添加
     * @param teacher
     * @param image
     * @return
     */
    @RequestMapping("/add")
    public String add(Teacher teacher, MultipartFile image){
        try {
            String diskPath="E://img/"+image.getOriginalFilename();
            String serverPath="/uploadImages/"+image.getOriginalFilename();
            if(StringUtils.isNotBlank(image.getOriginalFilename())){
                FileUtils.copyInputStreamToFile(image.getInputStream(),new File(diskPath));
            teacher.setImagePath(serverPath);
            }

            teacherService.save(teacher);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/teacher/listPager";
    }

    /**
     * 修改
     * @param teacher
     * @param image
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Teacher teacher, MultipartFile image){
        try {
            String diskPath="E://img/"+image.getOriginalFilename();
            String serverPath="/uploadImages/"+image.getOriginalFilename();
            if(StringUtils.isNotBlank(image.getOriginalFilename())){
                FileUtils.copyInputStreamToFile(image.getInputStream(),new File(diskPath));
                teacher.setImagePath(serverPath);
            }

            teacherService.save(teacher);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/teacher/listPager";
    }

    /**
     * 删除
     * @param bid
     * @return
     */
    @RequestMapping("/del/{bid}")
    public String del(@PathVariable(value = "bid") Integer bid){
        teacherService.deleteById(bid);
        return "redirect:/teacher/listPager";
    }
}
