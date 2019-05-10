package com.hospital.service;

import com.hospital.pojo.NewsPOJO;

import java.util.List;

public interface INewsService {
    List<NewsPOJO> showNews();
    Integer countNews();
}
