package com.hospital.mapper;

import com.hospital.pojo.NewsPOJO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {
    List<NewsPOJO> selectAllNews();
    Integer countNews();
}
