package com.hospital.controller;

import com.hospital.pojo.User;
import com.hospital.service.IOrderService;
import com.hospital.service.IValidFormService;
import com.hospital.utils.ConstCommons;
import com.hospital.utils.OutputCommons;
import com.hospital.utils.ParamType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/DoPostBack")
public class ValidFormController {
    @Resource
    private IValidFormService validFormService;
    
    @Resource
    private IOrderService orderService;

    @RequestMapping(value = "/GetMemberInfo",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkLogin(HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        String str="";
        if(user != null){
            str="您好，<a href='MemberReg.html'>"+user.getTbName()+"</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href='#' onclick='exit()'>[退出]</a>";
        }else {
            str="您好，请&nbsp;<a href='Login.html'>登录</a>&nbsp;|&nbsp;<a href='Register.html'>注册</a>";
        }
        return str;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(HttpSession session){
       return (User) session.getAttribute("user");
    }

    @RequestMapping("/LoginOut")
    @ResponseBody
    public String loginOut(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user != null){
            session.removeAttribute("user");
            //session.invalidate();//调用session的invalidate()方法，将保存的session删除
        }
        return "index.html";
    }

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

    @RequestMapping("/DoOrder")
    @ResponseBody
    public OutputCommons doOrder(String tbTokenOrder, String tbNumber, String tbCode, HttpSession session){
        OutputCommons output = new OutputCommons();
        User user = (User) session.getAttribute("user");
        if(user != null){
            if(VerificationCodeController.sRand.equalsIgnoreCase(tbCode)){
                int result = orderService.generateOrder(user, tbTokenOrder, tbNumber);
                if(result == 1){
                    output.setStatus(ConstCommons.SUCCESS);
                    output.setInfo("预约成功");
                }
            }else {
                //校验验证码是否正确
                output.setStatus(ConstCommons.ERROR);
                output.setInfo(ParamType.CODE.getMsg());
            }
        }else{
            output.setStatus(ConstCommons.ERROR);
            output.setInfo("请先登录！");
        }

        return output;
    }

    @RequestMapping("/DoChangePassword")
    @ResponseBody
    public OutputCommons changePassword(String tbOPassword, String tbPassword, String tbDPassword, HttpSession session) throws Exception {
        OutputCommons output = new OutputCommons();
        if(!tbPassword.equals(tbDPassword)){
            output.setStatus(ConstCommons.ERROR);
            output.setInfo("两次输入密码不一致！");
        }
        User user = (User)session.getAttribute("user");
        int resultNumber = validFormService.changePassword(tbOPassword, tbPassword, user);
        if(resultNumber == 0){
            output.setStatus(ConstCommons.ERROR);
            output.setInfo("您输入的原始密码错误");
        }else {
            output.setStatus(ConstCommons.SUCCESS);
            output.setInfo("");
        }
        return output;
    }

}
