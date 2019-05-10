package com.hospital.service;

import com.hospital.mapper.NewsMapper;
import com.hospital.pojo.NewsPOJO;
import com.hospital.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;

@Service
public class NewsService implements INewsService{
    @Resource
    private NewsMapper newsMapper;
    public List<NewsPOJO> showNews() {
        List<NewsPOJO> newsPOJO = newsMapper.selectAllNews();
        Collections.sort(newsPOJO, new Comparator<NewsPOJO>() {
            public int compare(NewsPOJO o1, NewsPOJO o2) {
                try {
                    return (int) (DateUtil.CUSTOM_DAY_FORMATOR.parse(o2.getTime()).getTime() - DateUtil.CUSTOM_DAY_FORMATOR.parse(o1.getTime()).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
        return newsPOJO;
    }

    public Integer countNews() {
        Integer countNews = newsMapper.countNews();
        return countNews;
    }
}
