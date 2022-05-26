package com.ali.my_take_out.dto;

import com.ali.my_take_out.entity.Setmeal;
import com.ali.my_take_out.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
