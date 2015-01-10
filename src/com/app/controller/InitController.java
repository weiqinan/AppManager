package com.app.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.dao.AppDAO;
import com.app.dao.NodeDAO;
import com.app.dao.UserDAO;
import com.app.model.App;
import com.app.model.Category;
import com.app.service.GeneralService;

@Controller
@RequestMapping("/init")
public class InitController {

    
    @Autowired
    ServletContext context;
    
    @Autowired
    private NodeDAO aNodeDAO;
    
    @Autowired
    private AppDAO aAppDAO;
    
    @Autowired
    private UserDAO aUserDAO;
    
    @Autowired
    private GeneralService gService;
    
    @RequestMapping(value = "/createCat", method = RequestMethod.GET)
    public String createCategories(Model model) {
        
    	Category cat1 = new Category();
    	cat1.setName("�罻");
    	
    	String[] categories = {"�罻", "��Ƶ", "�Ķ�", "����", "����", "ϵͳ", "��ȫ"};
    	
        for(String tempStr : categories) {
        	Category cat = new Category();
        	cat.setName(tempStr);
        	aAppDAO.upsertCat(tempStr);
        }
    	
    	Category cat2 = new Category();
    	cat2.setName("��Ƶ");
    	
    	Category cat3 = new Category();
    	cat3.setName("�Ķ�");
    	
    	Category cat4 = new Category();
    	cat4.setName("����");
    	
    	Category cat5 = new Category();
    	cat5.setName("����");
    	
    	Category cat6 = new Category();
    	cat6.setName("ϵͳ");
        
        return null;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddApp(Model model) {
    	return "uploadApp";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showApp(Model model) {
    	
    	//��ȡ���п�ѡ�����
    	
    	
    	return "admin";
    }
    
}
