package cn.com.straw.portal.controller;


import cn.com.straw.portal.dto.StudentRegisterDTO;
import cn.com.straw.portal.ex.ClassDisabledException;
import cn.com.straw.portal.ex.InsertException;
import cn.com.straw.portal.ex.InviteCodeException;
import cn.com.straw.portal.ex.PhoneDuplicateException;
import cn.com.straw.portal.service.IUserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.SneakyThrows;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tedu.cn
 * @since 2021-06-09
 */
@RestController
@RequestMapping("/portal/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/register/student")
    public String registerStudent(StudentRegisterDTO studentRegisterDTO){
        JSONObject result=new JSONObject();
        try {

            userService.registerStudent(studentRegisterDTO);
            result.put("message","注册成功！");
            result.put("state","1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String resultString=result.toString();
        return resultString;

    }
}
