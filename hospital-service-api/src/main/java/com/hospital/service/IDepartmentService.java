package com.hospital.service;

import com.hospital.pojo.Doctor;
import com.hospital.pojo.OfficesPOJO;

import java.util.HashMap;
import java.util.List;

public interface IDepartmentService {
    List<OfficesPOJO> getOffices();
    HashMap<String, List<Doctor>> getDoctors();
}
