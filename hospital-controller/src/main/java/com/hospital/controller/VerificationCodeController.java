package com.hospital.controller;

import com.hospital.pojo.User;
import com.hospital.service.IValidFormService;
import com.hospital.utils.ConstCommons;
import com.hospital.utils.ImageCode;
import com.hospital.utils.OutputCommons;
import com.hospital.utils.ParamType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/Validation")
public class VerificationCodeController {
    /*
     * @Resource默认按 byName 自动注入,是J2EE提供的， 需导入Package: javax.annotation.Resource;
     *
     * @Resource有两个中重要的属性：name和type ，而Spring将@Resource注解的name属性解析为bean的
     * 名字，而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，而使用 type属性时则使用
     * byType自动注入策略。如果既不指定name也不指定type属性，这时将通过反射机制使用by Name自动注入策略。
     */
    @Resource
    private ImageCode imageCode;

    @Resource
    private IValidFormService validFormService;

    private static String sRand;

    @RequestMapping(value = "/DoRegister")
    @ResponseBody
    public OutputCommons openLoginPage(User user) throws Exception {
        OutputCommons output = new OutputCommons();
        if(user.getTbPassword().equals(user.getTbDPassword())) {
            if (sRand.equalsIgnoreCase(user.getTbCode())) {
                int suc = validFormService.userRegister(user);
                if(suc == 1){
                output.setStatus(ConstCommons.SUCCESS);
                output.setInfo("");
                return output;
                }
                output.setStatus(ConstCommons.ERROR);
                output.setInfo("注册失败");
                return output;
            } else {
                //校验验证码是否正确
                output.setStatus(ConstCommons.ERROR);
                output.setInfo(ParamType.CODE.getMsg());
                return output;
            }
        }else {
            //密码校验不通过，两次不一致
            output.setStatus(ConstCommons.ERROR);
            output.setInfo(ParamType.PASSWORD.getMsg());
            return output;
        }
    }

    @RequestMapping("/DoLogin")
    @ResponseBody
    public OutputCommons login(User user) throws Exception {
        OutputCommons output = new OutputCommons();
        if(sRand.equalsIgnoreCase(user.getTbCode())){
            User checkUser = validFormService.userLogin(user);
            if(checkUser != null){
                output.setStatus(ConstCommons.SUCCESS);
                output.setInfo("");
                return output;
            }
            output.setStatus(ConstCommons.ERROR);
            output.setInfo("登录失败");
            return output;
        }
        //校验验证码是否正确
        output.setStatus(ConstCommons.ERROR);
        output.setInfo(ParamType.CODE.getMsg());
        return output;
    }

    @RequestMapping(value = "/getImage")
    public void getImage(HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        // 禁止图片缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到servlet输出流中
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(imageCode.getImage(request), "jpeg", sos);
        sos.close();
        sRand = (String) request.getAttribute("sRand");
        String result = "ok";

    }
}
