package org.huangpu.gongdi.service.impl;


import org.huangpu.gongdi.service.GeneralService;
import org.huangpu.gongdi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private GeneralService generalService;


}
