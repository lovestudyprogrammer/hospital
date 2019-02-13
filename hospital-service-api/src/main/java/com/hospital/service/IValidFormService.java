package com.hospital.service;

import com.hospital.pojo.User;

public interface IValidFormService {
    User checkExists(String pNumber,String cNumber,String email);
}
