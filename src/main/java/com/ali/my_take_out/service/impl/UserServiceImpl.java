package com.ali.my_take_out.service.impl;

import com.ali.my_take_out.entity.User;
import com.ali.my_take_out.mapper.UserMapper;
import com.ali.my_take_out.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
