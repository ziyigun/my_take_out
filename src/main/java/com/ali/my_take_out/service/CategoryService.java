package com.ali.my_take_out.service;

import com.ali.my_take_out.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CategoryService extends IService<Category> {
    //删除分类
    public void remove(Long id);
}
