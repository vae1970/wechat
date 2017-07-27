package com.vae.wechat.controller;

import com.alibaba.fastjson.JSONArray;
import com.vae.wechat.dao.IFileClassDao;
import com.vae.wechat.model.FileClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {

    private IFileClassDao iFileClassDao;

    @GetMapping("/login")
    @ResponseBody
    public String login(){
        List<FileClass> list = iFileClassDao.getListByType("ht");
//        JSONArray jsonArray = JSONArray.par
        return JSONArray.toJSONString(list);
    }
}
