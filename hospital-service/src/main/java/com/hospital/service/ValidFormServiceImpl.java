package com.hospital.service;

import com.hospital.mapper.UserMapper;
import com.hospital.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ValidFormServiceImpl implements IValidFormService {
    @Resource
    private UserMapper userMapper;
    public User checkExists(String pNumber,String cNumber,String email) {
        return userMapper.checkExists(pNumber,cNumber,email);
    }
}
