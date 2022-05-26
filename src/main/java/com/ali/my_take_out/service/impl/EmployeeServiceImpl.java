package com.ali.my_take_out.service.impl;

import com.ali.my_take_out.entity.Employee;
import com.ali.my_take_out.mapper.EmployeeMapper;
import com.ali.my_take_out.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService{

}
