package com.springmvcmaventutorial.controller;  
  
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvcmaventutorial.service.api.CommonService;
  
@Controller  
public class MainController {
	
    private CommonService commonService;

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "home";
	}
}  