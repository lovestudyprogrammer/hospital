package com.hospital.service;

import com.hospital.pojo.User;
import com.hospital.pojo.UserOrdersPOJO;

import java.util.List;

public interface IOrderService {
    int generateOrder(User user, String doctorId, String tbNumber);
    List<UserOrdersPOJO> showOrders(User user);
    int cancelOrder(String id);
}
