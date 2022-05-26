package com.ali.my_take_out.service;

import com.ali.my_take_out.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

public interface OrderService extends IService<Orders> {
    //用户下单
    public void submit(Orders orders);
}
