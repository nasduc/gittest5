package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.dao.Cat;
import com.example.demo.dao.person;
import com.example.demo.resp.BaseResp;
import com.example.demo.resp.ResultStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    @RequestMapping("/test1")
    public String test1(){
        return "test1";
    }


    @RequestMapping("/test2")
    public String test2(){
        Date date=new Date();
        person p1=new person(10,20,"jack",date);
        return JSON.toJSONString(p1);
    //    return JSON.toJSONString(p1, SerializerFeature.WriteClassName);
    }

    //反序列化
    @RequestMapping("/test3")
    public String test3(){
        Date date=new Date();
        person p1=new person(10,20,"jack",date);
        String s=JSON.toJSONString(p1).toString();
        person p3=JSON.parseObject(s,person.class);
        return p3.getName();
    }

    @RequestMapping("/test4")
    public BaseResp test4(){
        return  new BaseResp(ResultStatus.SUCCESS);
    }

    @RequestMapping("/test5")
    public person test5(){
        return  new person(20,30,"mick");
    }

    @RequestMapping("/test6")
    public Cat test6(){
        return  new Cat(20,123);
    }


}
