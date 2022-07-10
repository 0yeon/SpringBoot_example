package com.example.demo.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.UserVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
	Date time = new Date();
	String localTime = format.format(time);
	
	@Autowired
	UserMapper userMapper;
	
	@Transactional
	public void joinUser(UserVO userVo) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		
	}
	
}
