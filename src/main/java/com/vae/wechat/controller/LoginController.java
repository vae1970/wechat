package com.vae.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.vae.wechat.dao.IFileClassDao;
import com.vae.wechat.model.FileClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private IFileClassDao iFileClassDao;

    @GetMapping("/login")
    @ResponseBody
    public Object login(@RequestParam("a") int number, @RequestParam("b") String string){
        List<FileClass> list = iFileClassDao.getListByType("ht");
//        JSONArray jsonArray = JSONArray.par
        JSONObject object = new JSONObject();
        object.put("key","value");
//        return JSONArray.toJSONString(list);
        String a = "asd";
        System.out.println(a.hashCode());
        return object;
    }
}
