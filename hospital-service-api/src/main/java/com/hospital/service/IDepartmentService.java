package com.hospital.service;

import com.hospital.pojo.DoctorsPOJO;
import com.hospital.pojo.OfficesPOJO;

import java.util.List;

public interface IDepartmentService {
    List<OfficesPOJO> getOffices();
    List<DoctorsPOJO> getDoctors();
}
