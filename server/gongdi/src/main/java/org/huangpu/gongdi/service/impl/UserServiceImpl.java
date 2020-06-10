package org.huangpu.gongdi.service.impl;


import org.huangpu.gongdi.service.GeneralService;
import org.huangpu.gongdi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private GeneralService generalService;


}
