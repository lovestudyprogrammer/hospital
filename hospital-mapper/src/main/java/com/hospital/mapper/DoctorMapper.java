package com.hospital.mapper;

import com.hospital.pojo.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorMapper {
    List<Doctor> selectAll();
}
