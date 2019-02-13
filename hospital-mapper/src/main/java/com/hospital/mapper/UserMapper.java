package com.hospital.mapper;

import com.hospital.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User checkExists(@Param("pNumber") String pNumber, @Param("cNumber") String cNumber, @Param("email") String email);
}
