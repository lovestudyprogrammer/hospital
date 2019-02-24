package com.hospital.mapper;

import com.hospital.pojo.OfficesPOJO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    List<OfficesPOJO> selectAll();
}
