package com.hospital.controller;

import com.hospital.pojo.User;
import com.hospital.service.IValidFormService;
import com.hospital.utils.ConstCommons;
import com.hospital.utils.OutputCommons;
import com.hospital.utils.ParamType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/DoPostBack")
public class ValidFormController {
    @Resource
    private IValidFormService validFormService;

    @RequestMapping("/DoSearchByParms")
    @ResponseBody
    public OutputCommons checkParams(String param, String name){
        User user = null;
        OutputCommons output = new OutputCommons();
        if(StringUtils.isBlank(param)) {
            output.setStatus(ConstCommons.ERROR);
            output.setInfo("手机号不能为空！");
        }
        //校验手机号是否存在
        if (ParamType.PHONE.getName().equals(name)){
            user = validFormService.checkExists(param,null,null);
            if(user != null){
                output.setStatus(ConstCommons.ERROR);
                output.setInfo(ParamType.PHONE.getMsg());
            }else {
                output.setStatus(ConstCommons.SUCCESS);
                output.setInfo("");
            }
        }
        //校验身份证是否存在
        if (ParamType.CARDID.getName().equals(name)){
            user = validFormService.checkExists(null, param, null);
            if (user != null){
                output.setStatus(ConstCommons.ERROR);
                output.setInfo(ParamType.CARDID.getMsg());
            }else {
                output.setStatus(ConstCommons.SUCCESS);
                output.setInfo("");
            }
        }
        //校验邮箱是否存在
        if (ParamType.EMAIL.getName().equals(name)){
            user = validFormService.checkExists(null, null, param);
            if (user != null){
                output.setStatus(ConstCommons.ERROR);
                output.setInfo(ParamType.EMAIL.getMsg());
            }else {
                output.setStatus(ConstCommons.SUCCESS);
                output.setInfo("");
            }
        }

        return output;
    }

    /*@RequestMapping("/DoRegister")
    public void register(User user){

    }*/
}
