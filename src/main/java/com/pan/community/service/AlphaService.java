package com.pan.community.service;

import com.pan.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;

    public AlphaService() {
        System.out.println("实例化 AlphaService ");
    }
    @PostConstruct
    public void init1() {
        System.out.println("  init AlphaService! ");
    }

    @PreDestroy
    public void destroy1() {
        System.out.println("销毁  AlphaService");
    }

    public String find() {
        return alphaDao.select();
    }
}
