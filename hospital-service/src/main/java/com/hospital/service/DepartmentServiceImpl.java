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
import java.util.HashMap;
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

    public HashMap<String, List<Doctor>> getDoctors() {
        List<Doctor> doctors = doctorMapper.selectAll();
        DoctorsPOJO doctorsPOJO = new DoctorsPOJO();
        HashMap<String, List<Doctor>> hashMap = new HashMap<String, List<Doctor>>();
        Iterator<Doctor> iterator = doctors.iterator();
        while (iterator.hasNext()){
            Doctor doctor = iterator.next();
            //得到名字首字母
            String firstSpell = PinYinUtil.getFirstSpell(doctor.getDName());
            //按字典顺序分组
            for(char a='A'; a<='Z'; a++) {
                if (String.valueOf(a).equals(firstSpell)) {
                    if (doctorsPOJO.getChar().equals(firstSpell)) {
                        List<Doctor> doctorList = doctorsPOJO.getDoctors();
                        doctorList.add(doctor);
                        break;
                    } else {
                        doctorsPOJO.setChar(firstSpell);
                        List<Doctor> list = new ArrayList<Doctor>();
                        list.add(doctor);
                        hashMap.put(String.valueOf(a), list);
                        break;
                    }
                }
            }
        }
        return hashMap;
    }
}
