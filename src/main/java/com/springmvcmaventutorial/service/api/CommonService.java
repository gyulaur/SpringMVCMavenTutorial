package com.springmvcmaventutorial.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcmaventutorial.dao.CommonMapper;

public class CommonService {
	@Autowired
	CommonMapper commonMapper;
	
	public String getTeszt() {
		// TODO Auto-generated method stub
		return commonMapper.getTest();
	}

}
