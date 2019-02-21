package com.hospital.service;

import com.hospital.mapper.UserMapper;
import com.hospital.pojo.User;
import com.hospital.utils.ConstCommons;
import com.hospital.utils.DateUtil;
import com.hospital.utils.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class ValidFormServiceImpl implements IValidFormService {
    @Resource
    private UserMapper userMapper;
    public User checkExists(String pNumber,String cNumber,String email) {
        return userMapper.checkExists(pNumber,cNumber,email);
    }

    public int userRegister(User user) throws Exception {
        User checkUser;
        //生成id值
        String tbId = EncryptUtil.uuId();
        checkUser = userMapper.selectById(tbId);
        //校验数据库中是否存在此id
        while(checkUser != null){
            tbId = EncryptUtil.uuId();
            checkUser = userMapper.selectById(tbId);
        }
        //通过身份证获取用户年龄
        Map<String, String> map = DateUtil.getBirAgeSex(user.getTbCardID());
        user.setAge(Integer.parseInt(map.get("age")));
        user.setTbId(tbId);
        user.setTbPassword(EncryptUtil.encrypt(user.getTbPassword(), ConstCommons.DESKEY));
        int register = userMapper.insert(user);
        return register;
    }

    public User userLogin(User user) throws Exception {
        user.setTbPassword(EncryptUtil.encrypt(user.getTbPassword(), ConstCommons.DESKEY));
        User checkUser = userMapper.selectByCardIdAndPassword(user.getTbCardID(), user.getTbPassword());
        return checkUser;
    }
}
