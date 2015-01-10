package com.app.dao;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.app.model.App;
import com.app.model.Category;

/**
 *  APP DAO ͬʱ����� APP �� Category ��DAO ����
 */
@Component
public interface AppDAO {
    
    public void insertApp(String displayName, String fileName, String version, Set<Category> cats);
    
    public void insertApp(App anApp);
    
    public void findAppByCat (String catName);
    
    public void findAllApp ();
    
    public Category upsertCat(String catName);
    
    public Category upsertCat(String catName, Set<App> apps);
    
}
