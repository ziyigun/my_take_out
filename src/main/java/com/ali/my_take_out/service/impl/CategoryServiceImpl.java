package com.ali.my_take_out.service.impl;

import com.ali.my_take_out.common.CustomException;
import com.ali.my_take_out.entity.Category;
import com.ali.my_take_out.entity.Dish;
import com.ali.my_take_out.entity.Setmeal;
import com.ali.my_take_out.mapper.CategoryMapper;
import com.ali.my_take_out.service.CategoryService;
import com.ali.my_take_out.service.DishService;
import com.ali.my_take_out.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        //当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        if(count1 > 0){
            throw new CustomException("当前分类已经关联了菜品，不能删除");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        //当前分类是否关联了套餐
        if(count2 > 0){
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }

        //正常删除分类
        super.removeById(id);
    }
}
