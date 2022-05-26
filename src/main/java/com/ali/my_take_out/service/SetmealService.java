package com.ali.my_take_out.service;

import com.ali.my_take_out.dto.SetmealDto;
import com.ali.my_take_out.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {

    //新增套餐，同时保存套餐和菜品的关系
    public void saveWithDish(SetmealDto setmealDto);

    //删除套餐，同时删除套餐和菜品的关联数据
    public void removeWithDish(List<Long> ids);
}
