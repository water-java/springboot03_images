package com.hsl.springboot03.dao;

import com.hsl.springboot03.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-02 16:38
 * 增删改查
 */
public interface StudentsDao extends JpaRepository<Students,Integer> {
}
