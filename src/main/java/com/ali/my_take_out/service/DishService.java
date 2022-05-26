package com.ali.my_take_out.service;

import com.ali.my_take_out.common.R;
import com.ali.my_take_out.dto.DishDto;
import com.ali.my_take_out.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

public interface DishService extends IService<Dish> {

    //新增菜品，同时保存对应的口味信息
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);

    //更新菜品信息，同时更新口味信息
    public void updateWithFlavor(DishDto dishDto);

}
