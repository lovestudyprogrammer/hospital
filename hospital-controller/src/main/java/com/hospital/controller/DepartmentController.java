package com.hospital.controller;

import com.alibaba.fastjson.JSON;
import com.hospital.pojo.DoctorsPOJO;
import com.hospital.pojo.OfficesPOJO;
import com.hospital.service.IDepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/Offices")
public class DepartmentController {

    @Resource
    private IDepartmentService departmentService;

    @RequestMapping("/Department")
    @ResponseBody
    public String department(){
        List<OfficesPOJO> offices = departmentService.getOffices();
        return JSON.toJSONString(offices);
    }

    @RequestMapping("/Doctors")
    @ResponseBody
    public String doctors(){
        List<DoctorsPOJO> doctorsPOJOList = departmentService.getDoctors();
        return JSON.toJSONString(doctorsPOJOList);
    }
}
