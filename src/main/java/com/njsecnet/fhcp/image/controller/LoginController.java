package com.njsecnet.fhcp.image.controller;

import com.njsecnet.fhcp.image.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: fhcp-image
 * @Package: com.njsecnet.fhcp.image.controller
 * @ClassName: LoginController
 * @Description: 镜像中心登陆
 * @Author: wangyipin
 * @CreateDate: 2018/8/28 16:59
 * @Version: 1.0
 */
@Controller
@RequestMapping("/LoginController.do")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;


    public void doLogin(String name,String password){



        loginServiceImpl.login(name,password);


    }

}
