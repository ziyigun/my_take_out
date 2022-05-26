package com.ali.my_take_out.service.impl;

import com.ali.my_take_out.entity.DishFlavor;
import com.ali.my_take_out.mapper.DishFlavorMapper;
import com.ali.my_take_out.service.DishFlavorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
