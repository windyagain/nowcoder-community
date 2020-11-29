package com.pan.community;

import com.pan.community.dao.AlphaDao;
import com.pan.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

//@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class CommunityApplicationTests implements ApplicationContextAware {

//	@Test
//	void contextLoads() {
//	}
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public void testApplicationContext() {
		System.out.println("ok test =--= ");
	    System.out.println(applicationContext);
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

        AlphaDao alphaDao1 = applicationContext.getBean("alphaDaoHibernate", AlphaDao.class);
        System.out.println(alphaDao1.select());
	}

	@Test
	public void testBeanManagement() {
        AlphaService as = applicationContext.getBean(AlphaService.class);
        System.out.println(as);

        AlphaService as1 = applicationContext.getBean(AlphaService.class);
        System.out.println(as1 == as);
    }

    @Test
    public void testBeanConfig() {
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @Autowired
    private AlphaDao alphaDao;
	@Autowired
    private AlphaService alphaService;
	@Autowired
    private SimpleDateFormat simpleDateFormat;

	@Autowired
    private String myName;

	@Autowired
    @Qualifier("secName")
    private String secName1;
	@Test
    public void testDI() {
        System.out.println(alphaDao);
        System.out.println(alphaService);
        System.out.println(simpleDateFormat);
        //String name = applicationContext.getBean("myName", String.class);
        System.out.println(myName);
        System.out.println(secName1);
    }
}
