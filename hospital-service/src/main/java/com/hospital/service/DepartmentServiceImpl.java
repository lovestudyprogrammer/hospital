package com.hospital.service;

import com.hospital.mapper.DepartmentMapper;
import com.hospital.mapper.DoctorMapper;
import com.hospital.pojo.Doctor;
import com.hospital.pojo.DoctorsPOJO;
import com.hospital.pojo.OfficesPOJO;
import com.hospital.utils.PinYinUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private DoctorMapper doctorMapper;

    public List<OfficesPOJO> getOffices() {
        List<OfficesPOJO> list = departmentMapper.selectAll();
        return list;
    }

    public List<DoctorsPOJO> getDoctors() {
        List<Doctor> doctors = doctorMapper.selectAll();
        List<DoctorsPOJO> doctorsPOJOArrayList = new ArrayList<DoctorsPOJO>();
        //按字典顺序分组
        for(char a='A'; a<='Z'; a++) {
            List<Doctor> list = new ArrayList<Doctor>();
            DoctorsPOJO doctorsPOJO = new DoctorsPOJO();
            doctorsPOJO.setChar(String.valueOf(a));
            Iterator<Doctor> iterator = doctors.iterator();
            while (iterator.hasNext()){
                Doctor doctor = iterator.next();
                //得到名字首字母
                String firstSpell = PinYinUtil.getFirstSpell(doctor.getDName());
                if (String.valueOf(a).equals(firstSpell)) {
                    list.add(doctor);
                }
            }
            doctorsPOJO.setDoctors(list);
            doctorsPOJOArrayList.add(doctorsPOJO);
        }
        return doctorsPOJOArrayList;
    }
}
