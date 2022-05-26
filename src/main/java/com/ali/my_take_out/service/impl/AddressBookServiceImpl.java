package com.ali.my_take_out.service.impl;

import com.ali.my_take_out.entity.AddressBook;
import com.ali.my_take_out.mapper.AddressBookMapper;
import com.ali.my_take_out.service.AddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
