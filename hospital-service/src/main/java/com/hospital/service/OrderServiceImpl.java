package com.hospital.service;

import com.hospital.mapper.DepartmentMapper;
import com.hospital.mapper.DoctorMapper;
import com.hospital.mapper.OrderMapper;
import com.hospital.pojo.*;
import com.hospital.utils.DateTye;
import com.hospital.utils.DateUtil;
import com.hospital.utils.EncryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private DoctorMapper doctorMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private DepartmentMapper departmentMapper;

    public int generateOrder(User user, String doctorId, String tbNumber) {
        Orders order = new Orders();
        String doctorName = doctorMapper.selectByDoctorId(doctorId);
        if(StringUtils.isNotEmpty(doctorName)){
            //生成id值
            String orderId = EncryptUtil.uuId();
            String id = orderMapper.selectByOrderId(orderId);
            //校验数据库中是否存在此id
            while(StringUtils.isNotEmpty(id)){
                orderId = EncryptUtil.uuId();
                id = orderMapper.selectByOrderId(orderId);
            }
            //获取系统当前时间戳的后一天
            String afterDate = DateUtil.CUSTOM_DAY_FORMATOR.format(DateUtil.getSpecifiedDayAfter(DateUtil.CUSTOM_DAY_FORMATOR.format(new Date())));
            //获取用户预约时间段
            String orderTime = DateTye.getDateTypeByNumber(tbNumber);
            if(StringUtils.isNotEmpty(orderTime)){
                afterDate = afterDate+" "+orderTime;
            }
            order.setOId(orderId);
            order.setUserName(user.getTbName());
            order.setUserCardId(user.getTbCardID());
            order.setDate(afterDate);
            order.setDId(Integer.parseInt(doctorId));
            order.setDName(doctorName);
            order.setState(1);
        }
        int result = orderMapper.generateOrder(order);
        return result;
    }

    public List<UserOrdersPOJO> showOrders(User user) {
        ArrayList<UserOrdersPOJO> list = new ArrayList<UserOrdersPOJO>();
        //获取系统当前时间
        String dateNow = DateUtil.CUSTOM_DAY_FORMATOR.format(new Date());
        List<Orders> orders = orderMapper.selectByNameAndCardId(user.getTbName(), user.getTbCardID());
        if(orders != null){
            for (Orders order : orders) {
                //判断预约时间是否过期
                int i = DateUtil.compareDate(order.getDate(), dateNow);
                if(i == 1){
                    //过期数据，进行修改state状态值
                    if(order.getState() != 2){
                        order.setState(2);
                        orderMapper.updateOrderState(order.getOId());
                    }
                }
                UserOrdersPOJO userOrdersPOJO = new UserOrdersPOJO();
                userOrdersPOJO.setOrders(order);
                Doctor doctor = doctorMapper.selectById(order.getDId());
                if(doctor != null){
                    userOrdersPOJO.setDoctor(doctor);
                    Department department = departmentMapper.selectById(doctor.getOId());
                    if(department != null){
                        userOrdersPOJO.setDepartment(department);
                    }
                }
                list.add(userOrdersPOJO);
            }
        }
        return list;
    }

    public int cancelOrder(String id) {
        int num = orderMapper.updateById(id);
        return num;
    }
}
