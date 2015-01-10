package com.app.dao;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.app.model.Category;

/**
 *  APP DAO ͬʱ����� APP �� Category ��DAO ����
 */
@Component
public interface AppDAO {
    
    public void insertApp(String displayName, String fileName, String version, Set<Category> cats);
    
    public void findAppByCat (String catName);
    
    public void findAllApp ();
    
}
