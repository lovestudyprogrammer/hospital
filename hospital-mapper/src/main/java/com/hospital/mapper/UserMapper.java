package com.hospital.mapper;

import com.hospital.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User checkExists(@Param("pNumber") String pNumber, @Param("cNumber") String cNumber, @Param("email") String email);
    int insert(@Param("vo") User user);
    User selectById(String tbId);
    User selectByCardIdAndPassword(@Param("cardId") String cardId, @Param("password") String password);
}
