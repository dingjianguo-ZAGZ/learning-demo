package com.su.test;

import com.su.dao.UserDao;
import com.su.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {
    public static void main(String[] args) {
        //创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建读取器，与工厂绑定
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //读取配置文件给工厂
        reader.loadBeanDefinitions("beans.xml");
        //创建bean对象
        UserService userService = (UserService) beanFactory.getBean("userService");
        System.out.println(userService);

        UserDao userDao = (UserDao) beanFactory.getBean("userDao");
        System.out.println(userDao);
    }
}
