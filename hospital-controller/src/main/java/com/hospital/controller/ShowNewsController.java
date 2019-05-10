package com.hospital.controller;

import com.alibaba.fastjson.JSON;
import com.hospital.pojo.NewsPOJO;
import com.hospital.service.INewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/get")
public class ShowNewsController {
    @Resource
    private INewsService newsService;

    @RequestMapping("/news")
    @ResponseBody
    public String getAllNews() {
        List<NewsPOJO> news = newsService.showNews();
        return JSON.toJSONString(news);
    }

    @RequestMapping("/count")
    @ResponseBody
    public Integer countNews() {
        Integer toatlNews = newsService.countNews();
        return toatlNews;
    }
}
