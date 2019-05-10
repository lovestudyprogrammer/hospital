package com.hospital.mapper;

import com.hospital.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    String selectByOrderId(String id);
    int generateOrder(@Param("vo") Orders order);
    List<Orders> selectByNameAndCardId(@Param("userName") String userName, @Param("cardId") String cardId);
    int updateById(String id);
    int updateOrderState(String id);
}
