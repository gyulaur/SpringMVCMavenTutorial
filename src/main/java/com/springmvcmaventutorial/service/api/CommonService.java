package com.springmvcmaventutorial.service.api;

import com.springmvcmaventutorial.dao.CommonMapper;

public class CommonService {
	CommonMapper commonMapper;
	
	public CommonMapper getCommonMapper() {
		return commonMapper;
	}

	public void setCommonMapper(CommonMapper commonMapper) {
		this.commonMapper = commonMapper;
	}

	public String getTeszt() {
		// TODO Auto-generated method stub
		return commonMapper.getTest();
	}
}
