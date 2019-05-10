package com.hospital.controller;

import com.alibaba.fastjson.JSON;
import com.hospital.pojo.User;
import com.hospital.pojo.UserOrdersPOJO;
import com.hospital.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/show")
public class ShowMyOrderController {

    @Resource
    private IOrderService orderService;

    @RequestMapping("/orders")
    @ResponseBody
    public String showOrders(HttpSession session){
        User user = (User)session.getAttribute("user");
        List<UserOrdersPOJO> listOrders = null;
        if(user != null){
            listOrders = orderService.showOrders(user);
        }
        return JSON.toJSONString(listOrders);
    }

    @RequestMapping("/cancel")
    @ResponseBody
    public void cancel(String id){
        orderService.cancelOrder(id);
    }
}
