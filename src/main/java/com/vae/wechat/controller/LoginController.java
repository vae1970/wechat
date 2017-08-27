package com.vae.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.vae.wechat.dao.IFileClassDao;
import com.vae.wechat.model.FileClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private IFileClassDao iFileClassDao;

    @GetMapping("/login")
    @ResponseBody
    public Object login(@RequestParam("a") int number, @RequestParam("b") String string){
//        List<FileClass> list = iFileClassDao.getListByType("ht");
//        JSONArray jsonArray = JSONArray.par
        String a = "str";
        List<String> listUserName = new ArrayList<>();
        listUserName.add("vae9");
        listUserName.add("vae8");
        listUserName.add("vae7");
        iFileClassDao.insertUser(listUserName,"abcde","abc@qq.com");
        JSONObject object = new JSONObject();
        object.put("key","value");
//        return JSONArray.toJSONString(list);
        return object;
    }
}
