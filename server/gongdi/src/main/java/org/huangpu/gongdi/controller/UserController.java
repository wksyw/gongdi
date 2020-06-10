package org.huangpu.gongdi.controller;

import org.huangpu.gongdi.service.GeneralService;
import org.huangpu.gongdi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GeneralService generalService;



}
