package com.hospital.service;

import com.hospital.pojo.User;

public interface IValidFormService {
    User checkExists(String pNumber,String cNumber,String email);
    int userRegister(User user) throws Exception;
    User userLogin(User user) throws Exception;
    int changePassword(String tbOPassword, String tbPassword, User user) throws Exception;
}
