package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.util.FileOperateUtil;


/**
* 
*/
@Controller
@RequestMapping(value = "background/fileOperate")
public class FileController {
    
   /**
    * 到上传文件的位置
    * 
    */
   @RequestMapping(value = "to_upload")
   public ModelAndView toUpload() {
       return new ModelAndView("background/fileOperate/upload");
   }

   /**
    * 上传文件
    * 
    */
   @RequestMapping(value = "upload")
   public ModelAndView upload(HttpServletRequest request) throws Exception {

	   System.out.println("upload start");
       Map<String, Object> map = new HashMap<String, Object>();

       // 别名
       String[] alaises = ServletRequestUtils.getStringParameters(request,
               "alais");

       String[] params = new String[] { "alais" };
       Map<String, Object[]> values = new HashMap<String, Object[]>();
       values.put("alais", alaises);

      // List<Map<String, Object>> result = FileOperateUtil.upload(request,
      //         params, values, "weixin", "appPic", "1.0.0");

       /*
       List<Map<String, Object>> result = FileOperateUtil.upload(request,
    		     "weixin", "appPic", "1.0.0");
    		   
       map.put("result", result);
        */
       
       System.out.println("upload end");

       return new ModelAndView("Test", map);
   }

   /**
    * 下载
    * 
    */
   @RequestMapping(value = "download")
   public ModelAndView download(HttpServletRequest request,
           HttpServletResponse response) throws Exception {

       String storeName = "AppManager.7z";
       String realName = "AppManager_yuangonghao.7z";
       String contentType = "application/octet-stream";

       FileOperateUtil.download(request, response, storeName, contentType,
               realName);

       return null;
   }
}

