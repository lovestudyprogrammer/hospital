package com.hospital.service;

import com.hospital.mapper.DepartmentMapper;
import com.hospital.pojo.OfficesPOJO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    public List<OfficesPOJO> getOffices() {
        //HashMap<Department, List<Department>> map = new HashMap<Department, List<Department>>();
        List<OfficesPOJO> list = departmentMapper.selectAll();
        /*Iterator<OfficesPOJO> iterator = list.iterator();
        while (iterator.hasNext()){

        }*/

        return list;
    }
}
